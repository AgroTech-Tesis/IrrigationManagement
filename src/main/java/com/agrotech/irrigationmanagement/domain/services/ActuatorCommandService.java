/**
 * @summary
 * Service that handles the commands related to the favorite sources.
 * It is responsible for creating a new favorite source.
 */
package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateActuatorsCommand;

import java.util.Optional;

public interface ActuatorCommandService {
    Optional<Actuator> handle(CreateActuatorsCommand command);
}
