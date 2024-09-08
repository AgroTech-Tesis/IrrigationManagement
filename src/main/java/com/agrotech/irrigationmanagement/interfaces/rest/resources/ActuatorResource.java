package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record ActuatorResource(Long id, String name, String code, String model, Boolean isOn, LocalDateTime createdAt, LocalDateTime updatedAt) {
}