package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OptionsDTO {
    private UserDTO createdBy;
    private String id;
    private boolean lock;
    private boolean readOnly;
    private int selected;
    private String thingId;
}