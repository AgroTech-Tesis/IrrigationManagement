package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateNotificationCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateRiceCropCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateNotificationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateRiceCropResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toResourceFromEntity(CreateNotificationResource entity) {
        return new CreateNotificationCommand(entity.title(), entity.body(), entity.createdAt());
    }
}
