package com.agrotech.irrigationmanagement.application.internal.queryservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import com.agrotech.irrigationmanagement.domain.model.queries.GetNotificationAllQuery;
import com.agrotech.irrigationmanagement.domain.services.NotificationQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.NotificationRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {
    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> handle(GetNotificationAllQuery query) {
        Pageable pageable = PageRequest.of(query.pageNumber(), query.pageSize());
        return notificationRepository.getPagination(pageable);
    }
}
