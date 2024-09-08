package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateZoneCommand(String name, LocalDateTime createdAt, LocalDateTime updatedAt, Double waterAmount, Long riceCropId) {}
