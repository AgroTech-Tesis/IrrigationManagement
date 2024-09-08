package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Sensor;

import java.time.LocalDateTime;
import java.util.List;

public record DeviceResource(Long id, String deviceName, String deviceModel, LocalDateTime createdAt, LocalDateTime updatedAt, String isOn, String status, String media, List<ActuatorResource> actuators, List<SensorResource> sensors) {
}