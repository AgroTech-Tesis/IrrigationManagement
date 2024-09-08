/**
 * @summary
 * Service that handles the commands related to the favorite sources.
 * It is responsible for creating a new favorite source.
 */
package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateActuatorsCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;

import java.util.Optional;

public interface IrrigationCommandService {
    Optional<Irrigation> handle(CreateIrrigationCommand command);
    Optional<Irrigation> handle(Long irrigationId, IrrigationResource command);
}
