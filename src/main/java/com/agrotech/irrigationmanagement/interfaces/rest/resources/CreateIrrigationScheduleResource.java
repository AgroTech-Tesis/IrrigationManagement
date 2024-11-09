package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateIrrigationScheduleResource(Float irrigationTime, LocalDateTime irrigationDate, String name, Long riceCropId, String status) {
}