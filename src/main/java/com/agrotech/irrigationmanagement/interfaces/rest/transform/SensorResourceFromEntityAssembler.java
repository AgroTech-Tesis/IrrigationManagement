package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Sensor;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.ActuatorResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorResource;

public class SensorResourceFromEntityAssembler {
    public static SensorResource toResourceFromEntity(Sensor entity) {
        return new SensorResource(entity.getId(),
                entity.getName(),
                entity.getCode(),
                entity.getModel(),
                entity.getSensorValue(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
