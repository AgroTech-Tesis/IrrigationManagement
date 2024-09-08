package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;

public class IrrigationFromCreateIrrigationCommand {
    public static Irrigation toResourceFromEntity(CreateIrrigationCommand entity) {
        return new Irrigation(null, entity.createdAt(), entity.updatedAt(),
                entity.endedAt(), entity.waterAmount(), entity.irrigationNumber(), entity.daysPreviousIrrigation(), entity.status());
    }
}
