package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateRiceCropCommand(String name, String status, LocalDateTime createdAt, LocalDateTime updatedAt, Long farmerId) {}
