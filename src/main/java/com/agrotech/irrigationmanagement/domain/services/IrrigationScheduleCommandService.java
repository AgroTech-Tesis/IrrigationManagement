/**
 * @summary
 * Service that handles the commands related to the favorite sources.
 * It is responsible for creating a new favorite source.
 */
package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.IrrigationSchedule;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateActuatorsCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.DeleteIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.UpdateIrrigationScheduleCommand;

import java.util.Optional;

public interface IrrigationScheduleCommandService {
    Optional<IrrigationSchedule> handle(CreateIrrigationScheduleCommand command);
    Optional<IrrigationSchedule> handle(UpdateIrrigationScheduleCommand command);
    Optional<IrrigationSchedule> handle(DeleteIrrigationScheduleCommand command);
}
