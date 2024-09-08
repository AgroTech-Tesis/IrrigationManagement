package com.agrotech.irrigationmanagement.application.internal.queryservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByZoneIdQuery;
import com.agrotech.irrigationmanagement.domain.services.DeviceQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IDeviceRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceQueryServiceImpl implements DeviceQueryService {

    private final IZoneRepository zoneRepository;
    private final IDeviceRepository deviceRepository;

    public DeviceQueryServiceImpl(IZoneRepository zoneRepository, IDeviceRepository deviceRepository) {
        this.zoneRepository = zoneRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> handle() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<Device> handle(GetDeviceByIdQuery query) {
        return Optional.empty();
    }

    @Override
    public List<Device> handle(GetDeviceByZoneIdQuery query) {
        Zone zone = zoneRepository.findZoneEntitiesById(query.zoneId());
        if(zone == null) {
            throw new IllegalArgumentException("Zone not found");
        }
        try{
            return deviceRepository.findAllByZoneId(query.zoneId());
        }catch (Exception e){
            throw new IllegalArgumentException("Error");
        }
    }
}
