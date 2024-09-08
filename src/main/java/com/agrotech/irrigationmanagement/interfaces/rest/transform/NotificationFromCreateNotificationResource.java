package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.NotificationResource;

public class NotificationFromCreateNotificationResource {
    public static Notification NotificationFromCreateNotificationResource(NotificationResource entity) {
        return new Notification(entity.id(), entity.title(), entity.body(), entity.createdAt());
    }
}
