package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.ActuatorResource;

public class ActuatorResourceFromEntityAssembler {
    public static ActuatorResource toResourceFromEntity(Actuator entity) {
        return new ActuatorResource(entity.getId(),
                entity.getName(),
                entity.getModel(),
                entity.getCode(),
                entity.getIsOn(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
