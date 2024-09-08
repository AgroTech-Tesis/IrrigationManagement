package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateIrrigationCommand(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime endedAt, Double waterAmount, Integer irrigationNumber, Integer daysPreviousIrrigation, String status, Long riceCropId) {}
