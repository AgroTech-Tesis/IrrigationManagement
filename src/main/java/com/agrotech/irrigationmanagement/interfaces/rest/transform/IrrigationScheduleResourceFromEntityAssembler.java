package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.domain.model.aggregates.IrrigationSchedule;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationScheduleResource;

public class IrrigationScheduleResourceFromEntityAssembler {
    public static IrrigationScheduleResource toResourceFromEntity(IrrigationSchedule entity) {
        return new IrrigationScheduleResource(entity.getId(), entity.getIrrigationTime(), entity.getIrrigationDate(), entity.getName(), entity.getRiceCrop().getId());
    }
}
