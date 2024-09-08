package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.UpdateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateIrrigationScheduleResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.UpdateIrrigationScheduleResource;
import org.hibernate.sql.Update;

public class UpdateIrrigationScheduleCommandFromResourceAssembler {
    public static UpdateIrrigationScheduleCommand toResourceFromEntity(UpdateIrrigationScheduleResource entity) {
        return new UpdateIrrigationScheduleCommand(entity.id(), entity.irrigationTime(), entity.irrigationDate(),
                entity.name(), entity.riceCropId());
    }
}
