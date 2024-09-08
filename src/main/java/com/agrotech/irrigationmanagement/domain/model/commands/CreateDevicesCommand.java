package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateDevicesCommand(String deviceName, String deviceModel, LocalDateTime createdAt, LocalDateTime updatedAt, String isOn, String status, String media, Long zoneId) {}
