package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateNotificationCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.NotificationResource;

public class NotificationFromCreateNotificationCommand {
    public static Notification toResourceFromEntity(CreateNotificationCommand entity) {
        return new Notification(null, entity.title(), entity.body(), entity.createdAt());
    }
}
