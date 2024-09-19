package com.agrotech.irrigationmanagement.application.internal.queryservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.IrrigationSchedule;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.domain.model.queries.GetAllIrrigationScheduleByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByZoneIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationScheduleByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.DeviceQueryService;
import com.agrotech.irrigationmanagement.domain.services.IrrigationScheduleQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IDeviceRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IIrrigationScheduleRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IRiceCropsRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IrrigationScheduleQueryServiceImpl implements IrrigationScheduleQueryService {
    private final IIrrigationScheduleRepository irrigationScheduleRepository;
    private final IRiceCropsRepository riceCropsRepository;

    public IrrigationScheduleQueryServiceImpl(IIrrigationScheduleRepository irrigationScheduleRepository, IRiceCropsRepository riceCropsRepository) {
        this.irrigationScheduleRepository = irrigationScheduleRepository;
        this.riceCropsRepository = riceCropsRepository;
    }

    @Override
    public List<IrrigationSchedule> handle(GetAllIrrigationScheduleByRiceCropIdQuery query) {
        RiceCrop riceCrop = riceCropsRepository.findById(query.riceCropId()).orElse(null);
        if(riceCrop == null)
            throw new IllegalArgumentException("rice crop not found");
        try{
            return irrigationScheduleRepository.findAllByRiceCropIdAndStatus(query.riceCropId(), query.status());
        }catch (Exception e){
            throw new IllegalArgumentException("Error: ", e);
        }
    }

    @Override
    public Optional<IrrigationSchedule> handle(GetIrrigationScheduleByIdQuery query) {
        IrrigationSchedule irrigationSchedule = irrigationScheduleRepository.getIrrigationScheduleById(query.id());
        if (irrigationSchedule == null)
            throw new IllegalArgumentException("irrigation not found\"");

        return Optional.of(irrigationSchedule);
    }
}
