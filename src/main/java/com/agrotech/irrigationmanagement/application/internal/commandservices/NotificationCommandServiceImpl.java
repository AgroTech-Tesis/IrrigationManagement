package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateNotificationCommand;
import com.agrotech.irrigationmanagement.domain.services.NotificationCommandService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.NotificationRepository;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.NotificationFromCreateNotificationCommand;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {
    private final NotificationRepository notificationRepository;

    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Optional<Notification> handle(CreateNotificationCommand command) {
        try {
            var notification = NotificationFromCreateNotificationCommand.toResourceFromEntity(command);
            notification.setCreatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
            return Optional.of(notificationRepository.save(notification));
        }catch (Exception e){
            throw new IllegalArgumentException("Error Register Notification: ", e);
        }
    }
}
