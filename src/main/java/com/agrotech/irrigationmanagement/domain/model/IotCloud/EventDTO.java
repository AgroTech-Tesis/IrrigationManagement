package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private String name;
    private String updatedAt;
    private String value;
}
