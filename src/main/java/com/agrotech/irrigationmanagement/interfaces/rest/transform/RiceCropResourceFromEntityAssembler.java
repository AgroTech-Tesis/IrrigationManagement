package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.NotificationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.RiceCropResource;

public class RiceCropResourceFromEntityAssembler {
    public static RiceCropResource toResourceFromEntity(RiceCrop entity) {
        return new RiceCropResource(entity.getId(),
                entity.getName(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getFarmerId());
    }
}
