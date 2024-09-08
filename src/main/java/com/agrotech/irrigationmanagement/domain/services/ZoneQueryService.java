package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ZoneQueryService {
    List<Zone> handle();
    Optional<Zone> handle(GetZoneByIdQuery query);
    List<Zone> handle(GetZoneAllByRiceCropIdQuery query);
}
