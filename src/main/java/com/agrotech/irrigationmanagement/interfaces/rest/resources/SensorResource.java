package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record SensorResource(Long id, String name, String code, String model, String sensorValue, LocalDateTime createdAt, LocalDateTime updatedAt) {}
