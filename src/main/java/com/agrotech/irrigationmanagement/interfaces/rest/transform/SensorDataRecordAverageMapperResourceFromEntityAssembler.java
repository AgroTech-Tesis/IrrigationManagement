package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordAverage;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordResource;

public class SensorDataRecordAverageMapperResourceFromEntityAssembler {
    public static SensorDataRecordAverage toResourceFromEntity(Double sensor1, Double sensor2, Double sensor3) {
        return new SensorDataRecordAverage(sensor1, sensor2, sensor3);
    }
}
