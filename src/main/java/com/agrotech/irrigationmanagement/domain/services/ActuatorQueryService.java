package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.queries.GetActuatorByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ActuatorQueryService {
    List<Actuator> handle();
    Optional<Actuator> handle(GetActuatorByIdQuery query);
}
