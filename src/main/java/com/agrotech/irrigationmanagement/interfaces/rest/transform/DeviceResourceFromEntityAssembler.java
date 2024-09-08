package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;

public class DeviceResourceFromEntityAssembler {
    public static DeviceResource toResourceFromEntity(Device entity) {
        return new DeviceResource(entity.getId(),
                entity.getDeviceName(),
                entity.getDeviceModel(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getIsOn(),
                entity.getStatus(),
                entity.getMedia(),
                entity.getActuators().stream().map(ActuatorResourceFromEntityAssembler::toResourceFromEntity).toList(),
                entity.getSensors().stream().map(SensorResourceFromEntityAssembler::toResourceFromEntity).toList());
    }
}
