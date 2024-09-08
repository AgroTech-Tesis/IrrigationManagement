package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import com.agrotech.irrigationmanagement.domain.model.queries.GetNotificationAllQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneByIdQuery;

import java.util.List;
import java.util.Optional;

public interface NotificationQueryService {
    List<Notification> handle(GetNotificationAllQuery query);
}
