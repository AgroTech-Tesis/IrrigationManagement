package com.agrotech.irrigationmanagement.domain.model.queries;

import java.time.LocalDateTime;

public record GetNotificationAllQuery(LocalDateTime startDate, LocalDateTime endDate, int pageNumber, int pageSize) {
}