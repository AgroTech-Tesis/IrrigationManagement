package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateSensorDataCommand(Float lastValue, String typeSensor, Long sensorId) {}
