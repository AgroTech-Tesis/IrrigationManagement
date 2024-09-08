package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.ZoneResource;

public class ZoneFromCreateZoneResource {
    public static Zone ActuatorFromCreateActuatorResource(ZoneResource entity) {
        return new Zone(entity.id(), entity.name(), entity.createdAt(), entity.updatedAt(), entity.waterAmount());
    }
}
