package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ThingDTO {
    private String createdAt;
    private String deviceFqbn;
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private String href;
    private String id;
    private String name;
    private List<PropertyDTO> properties;
    private int propertiesCount;
    private String sketchId;
    private String timezone;
    private String updatedAt;
    private String userId;
    private boolean webhookActive;
}
