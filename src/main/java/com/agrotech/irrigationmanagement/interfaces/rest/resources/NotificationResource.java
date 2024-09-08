package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record NotificationResource(Long id, String title, String body, LocalDateTime createdAt) {
}