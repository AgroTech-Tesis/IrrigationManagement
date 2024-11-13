package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.*;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Sensor;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.domain.services.IotCloudCommandService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.ISensorDataRecordRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.ISensorRepository;
import com.agrotech.irrigationmanagement.interfaces.rest.Client.IotRESTClient;
import com.agrotech.irrigationmanagement.interfaces.rest.Client.TokenRESTClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class IotCloudCommandServiceImpl implements IotCloudCommandService {

    private final TokenRESTClient tokenRESTClient;
    private final IotRESTClient iotRESTClient;
    private final ISensorRepository sensorRepository;
    private final ISensorDataRecordRepository sensorDataRecordRepository;

    public IotCloudCommandServiceImpl(TokenRESTClient tokenRESTClient, IotRESTClient iotRESTClient, ISensorRepository sensorRepository, ISensorDataRecordRepository sensorDataRecordRepository) {
        this.tokenRESTClient = tokenRESTClient;
        this.iotRESTClient = iotRESTClient;
        this.sensorRepository = sensorRepository;
        this.sensorDataRecordRepository = sensorDataRecordRepository;
    }

    @Override
    public List<ThingDTO> getThing() {
        TokenDTO tokenDTO = getTokenIot();
        if (tokenDTO == null) {
            throw new RuntimeException("Error Token Iot cloud");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenDTO.getAccess_token());
        return iotRESTClient.getThing(headers);
    }

    @Override
    public List<DashboardDTO> getDashboard() {
        TokenDTO tokenDTO = getTokenIot();
        if (tokenDTO == null) {
            throw new RuntimeException("Error Token Iot cloud");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenDTO.getAccess_token());
        return iotRESTClient.getDashboard(headers);
    }

    @Override
    public List<DeviceIotDTO> getDevices() {
        TokenDTO tokenDTO = getTokenIot();
        if (tokenDTO == null) {
            throw new RuntimeException("Error Token Iot cloud");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenDTO.getAccess_token());
        return iotRESTClient.getDevices(headers);
    }

    //@Scheduled(fixedRate = 100000)
    //public void getSensorDataRecordScheduled() {
    //    List<DeviceIotDTO> deviceDtos = getDevices();
    //    if (deviceDtos == null)
    //        throw new IllegalArgumentException("deviceDtos is null");
    //    AtomicReference<String> status = new AtomicReference<>(new String());
    //    status.set(deviceDtos.get(0).getDevice_status());
    //    if(!status.get().equals("OFFLINE")){
    //        deviceDtos.get(0).getThing().getProperties().forEach(thingPropertyDTO -> {
    //            String[] parts = thingPropertyDTO.getName().split("_");
    //            if(parts.length != 1){
    //                Sensor sensors = sensorRepository.findSensorByName(parts[0] + " " + parts[2]);
    //                if(sensors != null){
    //                    SensorDataRecord sensorDataRecord = new SensorDataRecord();
    //                    sensorDataRecord.setLastValue(thingPropertyDTO.getLast_value());
    //                    sensorDataRecord.setCreatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
    //                    sensorDataRecord.setTypeSensor(parts[0].equals("caudal") ? "SENSOR DE CAUDAL" : parts[0].equals("temperature") ? "SENSOR DE TEMPERATURA" : parts[0].equals("moisture") ? "SENSOR DE HUMEDAD" :  parts[0].equals("humidity") ? "SENSOR DE HUMEDAD RELATIVA" : " - ");
    //                    sensorDataRecord.setSensor(sensors);
    //                    sensorDataRecordRepository.save(sensorDataRecord);
    //                }
    //            }
    //        });
    //    }
    //}

    @Override
    public TokenDTO getTokenIot() {
        CredentialTokenDTO credentialTokenDTO = new CredentialTokenDTO(Constants.GRANT_TYPE,
                Constants.CLIENT_ID,
                Constants.CLIENT_SECRET,
                Constants.AUDIENCE,
                Constants.TOKEN_URL);
        return tokenRESTClient.getToken(credentialTokenDTO);
    }
}
