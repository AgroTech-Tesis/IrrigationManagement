package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;

public class IrrigationResourceFromEntityAssembler {
    public static IrrigationResource toResourceFromEntity(Irrigation entity) {
        return new IrrigationResource(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(),
                entity.getEndedAt(), entity.getWaterAmount(), entity.getIrrigationNumber(), entity.getDaysPreviousIrrigation(), entity.getStatus());
    }
}
