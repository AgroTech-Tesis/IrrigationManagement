package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateSensorCommand(String name, String code, String model, String sensorValue, LocalDateTime createdAt, LocalDateTime updatedAt) {}
