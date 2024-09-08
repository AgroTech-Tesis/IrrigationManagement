package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification entity) {
        return new NotificationResource(entity.getId(), entity.getTitle(), entity.getBody(),
                entity.getCreatedAt());
    }
}
