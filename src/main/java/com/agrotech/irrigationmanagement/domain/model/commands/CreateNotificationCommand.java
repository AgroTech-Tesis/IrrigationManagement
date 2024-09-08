package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateNotificationCommand(String title, String body, LocalDateTime createdAt) {}
