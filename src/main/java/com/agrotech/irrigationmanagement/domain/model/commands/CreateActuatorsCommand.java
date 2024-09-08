package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateActuatorsCommand(String deviceName, String deviceModel, LocalDateTime createdAt, LocalDateTime updatedAt,  String isOn, Boolean status, String media) {}
