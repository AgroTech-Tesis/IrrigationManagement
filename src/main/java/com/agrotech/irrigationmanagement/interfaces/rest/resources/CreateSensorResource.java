package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record CreateSensorResource(String name, String code, String model, String sensorValue, LocalDateTime createdAt, Local updatedAt) {}
