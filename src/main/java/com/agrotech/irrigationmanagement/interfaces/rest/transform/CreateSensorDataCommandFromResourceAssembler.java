package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateRiceCropCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateSensorDataCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateRiceCropResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateSensorDataResource;

public class CreateSensorDataCommandFromResourceAssembler {
    public static CreateSensorDataCommand toResourceFromEntity(CreateSensorDataResource entity) {
        return new CreateSensorDataCommand(entity.lastValue(), entity.typeSensor(), entity.sensorId());
    }
}
