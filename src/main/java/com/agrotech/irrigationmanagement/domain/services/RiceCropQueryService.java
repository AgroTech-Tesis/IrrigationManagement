package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByFarmerIdAndStatusQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RiceCropQueryService {
    List<RiceCrop> handle();
    Optional<RiceCrop> handle(GetRiceCropByFarmerIdAndStatusQuery query);
    Optional<RiceCrop> handle(GetRiceCropByIdQuery query);
}
