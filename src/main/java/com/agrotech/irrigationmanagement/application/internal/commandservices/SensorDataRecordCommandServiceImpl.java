package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Sensor;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecordAverage;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecordListAverage;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateSensorDataCommand;
import com.agrotech.irrigationmanagement.domain.model.queries.GetSensorDataRecordAllQuery;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordCommandService;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.ISensorDataRecordRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.ISensorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SensorDataRecordCommandServiceImpl implements SensorDataRecordCommandService {
    private final ISensorDataRecordRepository sensorDataRecordRepository;
    private final ISensorRepository sensorRepository;

    public SensorDataRecordCommandServiceImpl(ISensorDataRecordRepository sensorDataRecordRepository, ISensorRepository sensorRepository) {
        this.sensorDataRecordRepository = sensorDataRecordRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Optional<SensorDataRecord> handle(CreateSensorDataCommand query) {
        try{
            Sensor sensor = sensorRepository.findById(query.sensorId()).orElseThrow(() -> new RuntimeException("Sensor not found"));
            SensorDataRecord sensorDataRecord = new SensorDataRecord(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)), query.lastValue(), query.typeSensor());
            sensorDataRecord.setSensor(sensor);
            sensorDataRecordRepository.save(sensorDataRecord);
            return Optional.of(sensorDataRecord);
        }catch (Exception e){
            throw new RuntimeException("Error saving sensor data record");
        }
    }
}
