package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateRiceCropCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.RiceCropResource;

public class RiceCropFromCreateRiceCropCommand {
    public static RiceCrop toResourceFromEntity(CreateRiceCropCommand entity) {
        return new RiceCrop(null,
                entity.name(),
                entity.status(),
                entity.createdAt(),
                entity.updatedAt(),
                entity.farmerId());
    }
}
