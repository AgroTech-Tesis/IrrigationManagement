package com.agrotech.irrigationmanagement.domain.model.queries;

public record GetIrrigationAllByRiceCropIdQuery(Long riceCropId, String status) {}