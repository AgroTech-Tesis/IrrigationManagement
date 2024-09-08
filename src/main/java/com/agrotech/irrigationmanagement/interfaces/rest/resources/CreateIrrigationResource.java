package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateIrrigationResource(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime endedAt, Double waterAmount, Integer irrigationNumber, Integer daysPreviousIrrigation, String status, Long riceCropId) {
}