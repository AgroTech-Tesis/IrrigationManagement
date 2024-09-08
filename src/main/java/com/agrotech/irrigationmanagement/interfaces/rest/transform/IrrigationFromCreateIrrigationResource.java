package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;

public class IrrigationFromCreateIrrigationResource {
    public static Irrigation IrrigationFromCreateIrrigationResource(IrrigationResource entity) {
        return new Irrigation(entity.id(), entity.createdAt(), entity.updatedAt(),
                entity.endedAt(), entity.waterAmount(), entity.irrigationNumber(), entity.daysPreviousIrrigation(), entity.status());
    }
}
