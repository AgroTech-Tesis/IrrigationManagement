/**
 * @summary
 * Service that handles the commands related to the favorite sources.
 * It is responsible for creating a new favorite source.
 */
package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateRiceCropCommand;

import java.util.Optional;

public interface RiceCropCommandService {
    Optional<RiceCrop> handle(CreateRiceCropCommand command);
}
