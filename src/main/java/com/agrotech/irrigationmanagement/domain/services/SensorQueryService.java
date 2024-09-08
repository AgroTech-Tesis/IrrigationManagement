package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByFarmerIdAndStatusQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetSensorByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SensorQueryService {
    List<Device> handle();
    Optional<Device> handle(GetSensorByIdQuery query);
}
