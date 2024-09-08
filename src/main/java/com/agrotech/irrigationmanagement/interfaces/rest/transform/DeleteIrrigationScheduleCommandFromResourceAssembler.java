package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.DeleteIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateIrrigationScheduleResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeleteIrrigationScheduleResource;
import org.hibernate.sql.Delete;

public class DeleteIrrigationScheduleCommandFromResourceAssembler {
    public static DeleteIrrigationScheduleCommand toResourceFromEntity(DeleteIrrigationScheduleResource entity) {
        return new DeleteIrrigationScheduleCommand(entity.id());
    }
}
