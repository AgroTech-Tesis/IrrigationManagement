package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByZoneIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface IrrigationQueryService {
    List<Irrigation> handle();
    List<Irrigation> handle(GetIrrigationAllByRiceCropIdQuery query);
    Optional<Irrigation> handle(GetIrrigationByIdQuery query);
}
