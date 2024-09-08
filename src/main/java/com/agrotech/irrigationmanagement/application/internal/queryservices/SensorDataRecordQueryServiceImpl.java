package com.agrotech.irrigationmanagement.application.internal.queryservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.domain.model.queries.GetSensorDataRecordAllQuery;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.ISensorDataRecordRepository;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorDataRecordQueryServiceImpl implements SensorDataRecordQueryService {
    private final ISensorDataRecordRepository sensorDataRecordRepository;

    public SensorDataRecordQueryServiceImpl(ISensorDataRecordRepository sensorDataRecordRepository) {
        this.sensorDataRecordRepository = sensorDataRecordRepository;
    }

    @Override
    public List<SensorDataRecord> handle(GetSensorDataRecordAllQuery query) {
        return sensorDataRecordRepository.getPagination(query.startDate(), query.endDate(), query.zoneId(), query.typeSensor());
    }
}
