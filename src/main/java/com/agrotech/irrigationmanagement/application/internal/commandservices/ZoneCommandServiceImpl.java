package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateZoneCommand;
import com.agrotech.irrigationmanagement.domain.services.ZoneCommandService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IRiceCropsRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IZoneRepository;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.ZoneFromCreateZoneCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ZoneCommandServiceImpl implements ZoneCommandService {
    private final IZoneRepository zoneRepository;
    private final IRiceCropsRepository riceCropsRepository;

    public ZoneCommandServiceImpl(IZoneRepository zoneRepository, IRiceCropsRepository riceCropsRepository) {
        this.zoneRepository = zoneRepository;
        this.riceCropsRepository = riceCropsRepository;
    }

    @Override
    public Optional<Zone> handle(CreateZoneCommand command) {
        RiceCrop riceCrop = riceCropsRepository.findById(command.riceCropId()).orElse(null);
        if(riceCrop == null)
            throw new IllegalArgumentException("riceCropId not found");
        var zone = ZoneFromCreateZoneCommand.toResourceFromEntity(command);
        try{
            zone.setRiceCrop(riceCrop);
            return Optional.of(zoneRepository.save(zone));
        }catch (Exception e) {
            throw new IllegalArgumentException("Error: ", e);
        }
    }
}
