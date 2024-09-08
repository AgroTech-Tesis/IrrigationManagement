package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateDeviceResource(String deviceName, String deviceModel, LocalDateTime createdAt, LocalDateTime updatedAt, String isOn, String status, String media, Long zoneId) {
}