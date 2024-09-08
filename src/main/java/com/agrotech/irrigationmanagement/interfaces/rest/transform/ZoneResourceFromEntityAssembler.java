package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.ZoneResource;

public class ZoneResourceFromEntityAssembler {
    public static ZoneResource toResourceFromEntity(Zone entity) {
        return new ZoneResource(entity.getId(), entity.getName(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getWaterAmount());
    }
}
