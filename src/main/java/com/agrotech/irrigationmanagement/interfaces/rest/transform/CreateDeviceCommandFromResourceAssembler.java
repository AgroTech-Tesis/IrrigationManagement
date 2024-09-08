package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.commands.CreateDevicesCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateDeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;

public class CreateDeviceCommandFromResourceAssembler {
    public static CreateDevicesCommand toResourceFromEntity(CreateDeviceResource entity) {
        return new CreateDevicesCommand(entity.deviceName(), entity.deviceModel(),
                entity.createdAt(), entity.updatedAt(), entity.isOn(), entity.status(), entity.media(), entity.zoneId());
    }
}
