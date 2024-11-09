package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateSensorDataResource(Float lastValue, String typeSensor, Long sensorId) {}
