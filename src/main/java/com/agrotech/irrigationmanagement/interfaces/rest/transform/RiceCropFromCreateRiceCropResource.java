package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.NotificationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.RiceCropResource;

public class RiceCropFromCreateRiceCropResource {
    public static RiceCrop RiceCropFromCreateRiceCropResource(RiceCropResource entity) {
        return new RiceCrop(entity.id(),
                entity.name(),
                entity.status(),
                entity.createdAt(),
                entity.updatedAt(),
                entity.farmerId());
    }
}
