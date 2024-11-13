package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {
    private String createdAt;
    private String href;
    private String id;
    private float lastValue;
    private float last_value;
    private boolean linkedToTrigger;
    private String name;
    private String permission;
    private boolean persist;
    private int tag;
    private String thingId;
    private String type;
    private int updateParameter;
    private String updateStrategy;
    private String updatedAt;
    private String valueUpdatedAt;
    private String variableName;
}
