package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.RiceCropResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordResource;

public class SensorDataResourceFromEntityAssembler {
    public static SensorDataRecordResource toResourceFromEntity(SensorDataRecord entity) {
        return new SensorDataRecordResource(entity.getCreatedAt(),
                entity.getLastValue(),
                entity.getTypeSensor());
    }
}
