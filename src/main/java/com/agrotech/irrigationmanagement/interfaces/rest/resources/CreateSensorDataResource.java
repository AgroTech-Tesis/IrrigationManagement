package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateSensorDataResource(String lastValue, String typeSensor, Long sensorId) {}
