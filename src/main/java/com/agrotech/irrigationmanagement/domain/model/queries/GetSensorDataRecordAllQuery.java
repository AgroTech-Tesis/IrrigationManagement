package com.agrotech.irrigationmanagement.domain.model.queries;

public record GetSensorDataRecordAllQuery(String startDate, String endDate, String zoneId, String typeSensor) {}