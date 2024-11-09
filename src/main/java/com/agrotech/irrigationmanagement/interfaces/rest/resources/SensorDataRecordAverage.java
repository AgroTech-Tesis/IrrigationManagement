package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record SensorDataRecordAverage(Double flowSensor, Double humiditySensor, Double temperatureSensor) {}
