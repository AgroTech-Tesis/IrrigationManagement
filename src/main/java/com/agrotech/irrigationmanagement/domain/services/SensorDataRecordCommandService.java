package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateSensorDataCommand;

import java.util.Optional;

public interface SensorDataRecordCommandService {
    Optional<SensorDataRecord> handle(CreateSensorDataCommand query);
}
