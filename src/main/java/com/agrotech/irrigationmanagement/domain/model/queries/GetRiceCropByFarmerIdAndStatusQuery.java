package com.agrotech.irrigationmanagement.domain.model.queries;

public record GetRiceCropByFarmerIdAndStatusQuery(Long farmerId, String status) {}