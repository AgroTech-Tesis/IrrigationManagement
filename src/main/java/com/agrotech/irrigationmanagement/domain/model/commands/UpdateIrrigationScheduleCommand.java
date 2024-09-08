package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record UpdateIrrigationScheduleCommand(Long id, Float irrigationTime, LocalDateTime irrigationDate, String name, Long riceCropId) {}
