package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record ZoneResource(Long id,
                           String name,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt,
                           Double waterAmount) {}
