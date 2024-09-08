package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.DeviceIotDTO;
import com.agrotech.irrigationmanagement.domain.model.aggregates.*;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateDevicesCommand;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.DeviceCommandService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.*;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.DeviceFromCreateDeviceCommand;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {
    private final IDeviceRepository deviceRepository;
    private final IZoneRepository zoneRepository;
    private final IotCloudCommandServiceImpl iotCloudCommandService;
    private final IRiceCropsRepository riceCropsRepository;
    private final ISensorRepository sensorRepository;
    private final IActuatorRepository actuatorRepository;

    public DeviceCommandServiceImpl(IDeviceRepository deviceRepository, IZoneRepository zoneRepository, IotCloudCommandServiceImpl iotCloudCommandService, IRiceCropsRepository riceCropsRepository, ISensorRepository sensorRepository, IActuatorRepository actuatorRepository) {
        this.deviceRepository = deviceRepository;
        this.zoneRepository = zoneRepository;
        this.iotCloudCommandService = iotCloudCommandService;
        this.riceCropsRepository = riceCropsRepository;
        this.sensorRepository = sensorRepository;
        this.actuatorRepository = actuatorRepository;
    }

    @Override
    public Optional<Device> handle(CreateDevicesCommand command) {
        Zone zone = zoneRepository.findZoneEntitiesById(command.zoneId());
        if(zone == null)
            throw new IllegalArgumentException("Zone not found");
        var device = DeviceFromCreateDeviceCommand.toResourceFromEntity(command);
        try{
            device.setZone(zone);
            deviceRepository.save(device);
            return Optional.of(device);
        }catch (Exception e){
            throw new IllegalArgumentException("Error: ", e);
        }
    }

    @Override
    public String devicesIot(GetRiceCropByIdQuery query) {
        RiceCrop riceCrops = riceCropsRepository.findById(query.id()).orElse(null);
        if(riceCrops != null){
            try {
                List<DeviceIotDTO> deviceDtos = iotCloudCommandService.getDevices();
                if (deviceDtos.isEmpty())
                    throw new IllegalArgumentException("Error");
                AtomicReference<String> status = new AtomicReference<>(new String());
                deviceDtos.get(0).getEvents().forEach(eventDTO -> {
                    if(eventDTO.getName().equals("r_status"))
                        status.set(eventDTO.getValue());
                });
                deviceDtos.get(0).getThing().getProperties().forEach(thingPropertyDTO -> {
                    String[] parts = thingPropertyDTO.getName().split("_");
                    Zone zones = new Zone();
                    Zone zonesData =  zoneRepository.findZonesByName(parts.length == 1 ? "Actuador" : "Parcela " + parts[2]);
                    if(zonesData == null){
                        zones.setName(parts.length == 1 ? "Actuador" : "Parcela " + parts[2]);
                        zones.setRiceCrop(riceCrops);
                        zones.setCreatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
                        zoneRepository.save(zones);
                    }
                });
                deviceDtos.get(0).getThing().getProperties().forEach(thingPropertyDTO -> {
                    String[] parts = thingPropertyDTO.getName().split("_");
                    Device devices = deviceRepository.findDevicesByDeviceName(parts.length == 1 ? "Actuador" : "Device " + parts[2]);
                    Zone zonesData = zoneRepository.findZonesByName(parts.length == 1 ? "Actuador" : "Parcela " + parts[2]);
                    if(zonesData != null && devices == null){
                        Device devicesSave = new Device();
                        devicesSave.setZone(zonesData);
                        devicesSave.setDeviceModel(parts.length == 1 ? "Esp32 principal" : "Esp32 - " + parts[2]);
                        devicesSave.setDeviceName(parts.length == 1 ? "Actuador" : "Device " + parts[2]);
                        devicesSave.setStatus(status.get());
                        devicesSave.setCreatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
                        deviceRepository.save(devicesSave);
                    }else {
                        devices.setStatus(status.get());
                        deviceRepository.save(devices);
                    }
                });
                deviceDtos.get(0).getThing().getProperties().forEach(thingPropertyDTO -> {
                    String[] parts = thingPropertyDTO.getName().split("_");
                    Device devices = deviceRepository.findDevicesByDeviceName(parts.length == 1 ? "Actuador" : "Device " + parts[2]);
                    if(parts.length == 1){
                        Actuator actuators = actuatorRepository.findActuatorsByName("Válvula Solenoide");
                        if(devices != null && actuators == null){
                            Actuator actuatorsData = new Actuator();
                            actuatorsData.setName("Válvula Solenoide");
                            actuatorsData.setCode(thingPropertyDTO.getId());
                            actuatorsData.setCreatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
                            actuatorsData.setDevice(devices);
                            actuatorRepository.save(actuatorsData);
                        }
                    }
                    else{
                        Sensor sensors = sensorRepository.findSensorByName(parts[0] + " " + parts[2]);
                        if(devices != null && sensors == null){
                            Sensor sensorsData = new Sensor();
                            sensorsData.setName(parts[0] + " " + parts[2]);
                            sensorsData.setCode(thingPropertyDTO.getId());
                            sensorsData.setCreatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
                            sensorsData.setDevice(devices);
                            sensorRepository.save(sensorsData);
                        }
                    }
                });
                return "Devices Iot is created";
            }catch (Exception e){
                throw new IllegalArgumentException("Error");
            }
        }
        return "Rice Crop is not found";
    }
}
