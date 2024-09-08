package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.DeviceIotDTO;
import com.agrotech.irrigationmanagement.domain.model.aggregates.*;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateDevicesCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.DeleteIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.UpdateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.DeviceCommandService;
import com.agrotech.irrigationmanagement.domain.services.IrrigationScheduleCommandService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.*;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.DeviceFromCreateDeviceCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.IrrigationFromCreateIrrigationCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.IrrigationScheduleFromCreateIrrigationScheduleCommand;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class IrrigationScheduleCommandServiceImpl implements IrrigationScheduleCommandService {
    private final IIrrigationScheduleRepository iIrrigationScheduleRepository;
    private final IRiceCropsRepository riceCropsRepository;

    public IrrigationScheduleCommandServiceImpl(IIrrigationScheduleRepository iIrrigationScheduleRepository, IRiceCropsRepository riceCropsRepository) {
        this.iIrrigationScheduleRepository = iIrrigationScheduleRepository;
        this.riceCropsRepository = riceCropsRepository;
    }

    @Override
    public Optional<IrrigationSchedule> handle(CreateIrrigationScheduleCommand command) {
        RiceCrop riceCrops = riceCropsRepository.findById(command.riceCropId()).orElse(null);
        if(riceCrops == null)
            throw new IllegalArgumentException("rice crop not found");
        var irrigationSchedule = IrrigationScheduleFromCreateIrrigationScheduleCommand.toResourceFromEntity(command);
        try {
            irrigationSchedule.setRiceCrop(riceCrops);
            iIrrigationScheduleRepository.save(irrigationSchedule);
            return Optional.of(irrigationSchedule);
        }catch (Exception e){
            throw new IllegalArgumentException("Error: ", e);
        }
    }

    @Override
    public Optional<IrrigationSchedule> handle(UpdateIrrigationScheduleCommand command) {
        IrrigationSchedule irrigationSchedule = iIrrigationScheduleRepository.findById(command.id()).orElse(null);
        if(irrigationSchedule == null)
            throw new IllegalArgumentException("rice crop not found");
        try{
            irrigationSchedule.setIrrigationDate(command.irrigationDate());
            irrigationSchedule.setIrrigationTime(command.irrigationTime());
            irrigationSchedule.setName(command.name());
            iIrrigationScheduleRepository.save(irrigationSchedule);
            return Optional.of(irrigationSchedule);
        }catch (Exception e){
            throw new IllegalArgumentException("Error: ", e);
        }
    }

    @Override
    public Optional<IrrigationSchedule> handle(DeleteIrrigationScheduleCommand command) {
        IrrigationSchedule irrigationSchedule = iIrrigationScheduleRepository.findById(command.scheduleIrrigationId()).orElse(null);
        if(irrigationSchedule == null)
            throw new IllegalArgumentException("rice crop not found");
        try{
            iIrrigationScheduleRepository.delete(irrigationSchedule);
            return Optional.of(irrigationSchedule);
        }catch (Exception e){
            throw new IllegalArgumentException("Error: ", e);
        }
    }
}
