package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class VariableDTO {
    private String id;
    private float lastValue;
    private String lastValueUpdatedAt;
    private String name;
    private String permission;
    private String thingId;
    private String thingName;
    private ThingTimezoneDTO thingTimezone;
    private String type;
    private String variableName;
}
