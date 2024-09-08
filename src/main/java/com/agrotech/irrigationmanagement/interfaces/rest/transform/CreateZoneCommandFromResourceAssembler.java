package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateDevicesCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateZoneCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateDeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateZoneResource;

public class CreateZoneCommandFromResourceAssembler {
    public static CreateZoneCommand toResourceFromEntity(CreateZoneResource entity) {
        return new CreateZoneCommand(entity.name(), entity.createdAt(),
                entity.updatedAt(), entity.waterAmount(), entity.riceCropId());
    }
}
