package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateDevicesCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;

public class DeviceFromCreateDeviceCommand {
    public static Device toResourceFromEntity(CreateDevicesCommand entity) {
        return new Device(null, entity.deviceName(), entity.deviceModel(),
                entity.createdAt(), entity.updatedAt(), entity.isOn(), entity.status(), entity.media());
    }
}
