package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.IrrigationSchedule;
import com.agrotech.irrigationmanagement.domain.model.queries.GetActuatorByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetAllIrrigationScheduleByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationScheduleByIdQuery;

import java.util.List;
import java.util.Optional;

public interface IrrigationScheduleQueryService {
    List<IrrigationSchedule> handle(GetAllIrrigationScheduleByRiceCropIdQuery query);
    Optional<IrrigationSchedule> handle(GetIrrigationScheduleByIdQuery query);
}
