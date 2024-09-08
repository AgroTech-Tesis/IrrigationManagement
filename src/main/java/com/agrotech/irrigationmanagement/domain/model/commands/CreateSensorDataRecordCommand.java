package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateSensorDataRecordCommand(LocalDateTime createdAt, Float lastValue, String typeSensor) {}
