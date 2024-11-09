package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecordAverage;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByFarmerIdAndStatusQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetSensorDataRecordAllQuery;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordResource;

import java.util.List;
import java.util.Optional;

public interface SensorDataRecordQueryService {
    List<SensorDataRecord> handle(GetSensorDataRecordAllQuery query);
    List<SensorDataRecordAverage> handle();
}
