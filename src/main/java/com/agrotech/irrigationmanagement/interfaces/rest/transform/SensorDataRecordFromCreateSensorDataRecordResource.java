package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.RiceCropResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordResource;

public class SensorDataRecordFromCreateSensorDataRecordResource {
    public static SensorDataRecord SensorDataRecordFromCreateSensorDataRecordResource(SensorDataRecordResource entity) {
        return new SensorDataRecord(entity.createdAt(),
                entity.lastValue(),
                entity.typeSensor());
    }
}
