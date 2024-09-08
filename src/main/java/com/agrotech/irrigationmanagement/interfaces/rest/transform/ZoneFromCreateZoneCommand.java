package com.agrotech.irrigationmanagement.interfaces.rest.transform;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateZoneCommand;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.ZoneResource;

public class ZoneFromCreateZoneCommand {
    public static Zone toResourceFromEntity(CreateZoneCommand entity) {
        return new Zone(null, entity.name(), entity.createdAt(), entity.updatedAt(), entity.waterAmount());
    }
}
