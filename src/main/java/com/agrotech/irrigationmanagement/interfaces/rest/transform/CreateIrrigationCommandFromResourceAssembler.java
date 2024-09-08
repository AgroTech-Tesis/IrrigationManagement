package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateZoneCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateIrrigationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateZoneResource;

public class CreateIrrigationCommandFromResourceAssembler {
    public static CreateIrrigationCommand toResourceFromEntity(CreateIrrigationResource entity) {
        return new CreateIrrigationCommand(entity.createdAt(), entity.updatedAt(), entity.endedAt(), entity.waterAmount(),
                entity.irrigationNumber(), entity.daysPreviousIrrigation(), entity.status(), entity.riceCropId());
    }
}
