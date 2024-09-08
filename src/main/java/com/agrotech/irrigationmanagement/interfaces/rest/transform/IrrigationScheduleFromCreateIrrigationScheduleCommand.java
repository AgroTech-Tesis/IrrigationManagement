package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.IrrigationSchedule;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateZoneCommand;

public class IrrigationScheduleFromCreateIrrigationScheduleCommand {
    public static IrrigationSchedule toResourceFromEntity(CreateIrrigationScheduleCommand entity) {
        return new IrrigationSchedule(null, entity.irrigationTime(), entity.irrigationDate(), entity.name());
    }
}
