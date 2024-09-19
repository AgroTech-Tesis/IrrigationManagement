package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateRiceCropResource(String name, String status, LocalDateTime createdAt, LocalDateTime updatedAt, Long farmerId) {}