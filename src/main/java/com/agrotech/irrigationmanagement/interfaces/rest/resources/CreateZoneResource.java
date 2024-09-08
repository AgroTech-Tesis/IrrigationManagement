package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateZoneResource(String name, LocalDateTime createdAt, LocalDateTime updatedAt, Double waterAmount, Long riceCropId) {}
