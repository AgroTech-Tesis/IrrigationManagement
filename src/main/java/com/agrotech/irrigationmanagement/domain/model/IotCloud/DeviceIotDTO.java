package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DeviceIotDTO {
    private String connectionType;
    private String createdAt;
    private String device_status;
    private List<EventDTO> events;
    private String fqbn;
    private String href;
    private String id;
    private String label;
    private String lastActivityAt;
    private String name;
    private boolean otaAvailable;
    private boolean otaCompatible;
    private String serial;
    private ThingDTO thing;
    private String type;
    private String userId;
}
