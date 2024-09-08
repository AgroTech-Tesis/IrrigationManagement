package com.agrotech.irrigationmanagement.application.internal.queryservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.ZoneQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IRiceCropsRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneQueryServiceImpl implements ZoneQueryService {
    private final IZoneRepository zoneRepository;
    private final IRiceCropsRepository riceCropsRepository;

    public ZoneQueryServiceImpl(IZoneRepository zoneRepository, IRiceCropsRepository riceCropsRepository) {
        this.zoneRepository = zoneRepository;
        this.riceCropsRepository = riceCropsRepository;
    }

    @Override
    public List<Zone> handle() {
        return zoneRepository.findAll();
    }

    @Override
    public Optional<Zone> handle(GetZoneByIdQuery query) {
        return Optional.of(zoneRepository.findZoneEntitiesById(query.id()));
    }

    @Override
    public List<Zone> handle(GetZoneAllByRiceCropIdQuery query) {
        RiceCrop riceCrop = riceCropsRepository.findById(query.riceCropId()).orElse(null);
        if(riceCrop == null)
            throw new IllegalArgumentException("riceCrops not found");
        try{
            return zoneRepository.findAllByRiceCropId(query.riceCropId());
        }catch (Exception e) {
            throw new IllegalArgumentException("Error: ", e);
        }
    }
}
