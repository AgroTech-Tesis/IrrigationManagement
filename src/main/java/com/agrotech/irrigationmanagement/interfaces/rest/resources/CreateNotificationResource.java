package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateNotificationResource(String title, String body, LocalDateTime createdAt) {
}