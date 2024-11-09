package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.queries.GetActuatorByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByZoneIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropsByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DeviceQueryService {
    List<Device> handle(GetRiceCropsByIdQuery query);
    Optional<Device> handle(GetDeviceByIdQuery query);
    List<Device> handle(GetDeviceByZoneIdQuery query);
}
