package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateRiceCropCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateIrrigationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateRiceCropResource;

public class CreateRiceCropCommandFromResourceAssembler {
    public static CreateRiceCropCommand toResourceFromEntity(CreateRiceCropResource entity) {
        return new CreateRiceCropCommand(entity.name(), entity.status(), entity.createdAt(), entity.updatedAt(), entity.farmerId());
    }
}
