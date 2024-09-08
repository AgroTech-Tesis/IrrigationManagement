/**
 * @summary
 * Service that handles the commands related to the favorite sources.
 * It is responsible for creating a new favorite source.
 */
package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateRiceCropCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateSensorCommand;

import java.util.Optional;

public interface SensorCommandService {
    Optional<Actuator> handle(CreateSensorCommand command);
}
