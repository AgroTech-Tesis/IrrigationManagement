package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;

public class DeviceFromCreateDeviceResource {
    public static Device toResourceFromEntity(DeviceResource entity) {
        return new Device(entity.id(), entity.deviceName(), entity.deviceModel(),
                entity.createdAt(), entity.updatedAt(), entity.isOn(), entity.status(), entity.media());
    }
}
