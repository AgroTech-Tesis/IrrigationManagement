package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record IrrigationScheduleResource(Long id, Float irrigationTime, LocalDateTime irrigationDate, String name, Long riceCropId) {
}