package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateSensorDataRecordResource(LocalDateTime createdAt, Float lastValue, String typeSensor) {}
