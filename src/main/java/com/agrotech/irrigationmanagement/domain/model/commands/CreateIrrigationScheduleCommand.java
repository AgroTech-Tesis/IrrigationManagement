package com.agrotech.irrigationmanagement.domain.model.commands;

import java.time.LocalDateTime;

public record CreateIrrigationScheduleCommand(Float irrigationTime, LocalDateTime irrigationDate, String name, Long riceCropId, String status) {}
