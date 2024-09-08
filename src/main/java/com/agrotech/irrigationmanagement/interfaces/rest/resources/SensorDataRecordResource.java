package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record SensorDataRecordResource(LocalDateTime createdAt, Float lastValue, String typeSensor) {}
