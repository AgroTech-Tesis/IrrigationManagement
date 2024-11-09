package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecordAverage;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecordListAverage;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateSensorDataCommand;
import com.agrotech.irrigationmanagement.domain.model.queries.GetSensorDataRecordAllQuery;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordCommandService;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.ISensorDataRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SensorDataRecordCommandServiceImpl implements SensorDataRecordCommandService {
    private final ISensorDataRecordRepository sensorDataRecordRepository;

    public SensorDataRecordCommandServiceImpl(ISensorDataRecordRepository sensorDataRecordRepository) {
        this.sensorDataRecordRepository = sensorDataRecordRepository;
    }

    @Override
    public Optional<SensorDataRecord> handle(CreateSensorDataCommand query) {
        try{
            SensorDataRecord sensorDataRecord = new SensorDataRecord(LocalDateTime.now(), query.lastValue(), query.typeSensor());
            sensorDataRecordRepository.save(sensorDataRecord);
            return Optional.of(sensorDataRecord);
        }catch (Exception e){
            throw new RuntimeException("Error saving sensor data record");
        }
    }
}
