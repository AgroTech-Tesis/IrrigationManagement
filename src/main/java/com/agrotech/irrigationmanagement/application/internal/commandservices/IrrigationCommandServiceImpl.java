package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationCommand;
import com.agrotech.irrigationmanagement.domain.services.IrrigationCommandService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IIrrigationRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IRiceCropsRepository;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.IrrigationFromCreateIrrigationCommand;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class IrrigationCommandServiceImpl implements IrrigationCommandService {
    private final IIrrigationRepository irrigationRepository;
    private final IRiceCropsRepository riceCropsRepository;

    public IrrigationCommandServiceImpl(IIrrigationRepository irrigationRepository, IRiceCropsRepository riceCropsRepository) {
        this.irrigationRepository = irrigationRepository;
        this.riceCropsRepository = riceCropsRepository;
    }

    @Override
    public Optional<Irrigation> handle(CreateIrrigationCommand command) {
        RiceCrop riceCrops = riceCropsRepository.findById(command.riceCropId()).orElse(null);
        if(riceCrops == null)
            throw new IllegalArgumentException("rice crop not found");
        var irrigation = IrrigationFromCreateIrrigationCommand.toResourceFromEntity(command);
        try {
            irrigation.setRiceCrop(riceCrops);
            irrigation.setWaterAmount(0.0);
            irrigation.setStatus(Constants.STATUS_ACTIVE);
            irrigation.setCreatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
            irrigationRepository.save(irrigation);
            return Optional.of(irrigation);
        }catch (Exception e){
            throw new IllegalArgumentException("Error: ", e);
        }
    }

    @Override
    public Optional<Irrigation> handle(Long irrigationId, IrrigationResource command) {
        Irrigation irrigation1 = irrigationRepository.findById(irrigationId).orElse(null);
        if(irrigation1 == null)
            throw new IllegalArgumentException("irrigation not found");
        try {
            irrigation1.setDaysPreviousIrrigation(command.daysPreviousIrrigation());
            irrigation1.setStatus(command.status());
            irrigation1.setIrrigationNumber(command.irrigationNumber());
            //irrigation1.setWaterAmount(irrigation.getWaterAmount());
            irrigation1.setUpdatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
            irrigationRepository.save(irrigation1);
            return Optional.of(irrigation1);
        }catch (Exception e) {
            throw new IllegalArgumentException("Error: ", e);
        }
    }
}
