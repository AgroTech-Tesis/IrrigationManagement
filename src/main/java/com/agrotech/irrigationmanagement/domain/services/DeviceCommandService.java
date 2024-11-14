/**
 * @summary
 * Service that handles the commands related to the favorite sources.
 * It is responsible for creating a new favorite source.
 */
package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateActuatorsCommand;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateDevicesCommand;
import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByIdQuery;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.UpdateDeviceIotResource;

import java.util.Optional;

public interface DeviceCommandService {
    Optional<Device> handle(CreateDevicesCommand command);
    String devicesIot(GetRiceCropByIdQuery query);
    String devicesEsp(GetRiceCropByIdQuery query, String deviceName);
    DeviceResource deviceUpdate(UpdateDeviceIotResource query);
}
