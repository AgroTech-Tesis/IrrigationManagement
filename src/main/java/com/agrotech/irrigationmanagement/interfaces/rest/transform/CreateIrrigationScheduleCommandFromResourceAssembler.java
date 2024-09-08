package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateDevicesCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateDeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateIrrigationScheduleResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationScheduleResource;

public class CreateIrrigationScheduleCommandFromResourceAssembler {
    public static CreateIrrigationScheduleCommand toResourceFromEntity(CreateIrrigationScheduleResource entity) {
        return new CreateIrrigationScheduleCommand(entity.irrigationTime(), entity.irrigationDate(),
                entity.name(), entity.riceCropId());
    }
}
