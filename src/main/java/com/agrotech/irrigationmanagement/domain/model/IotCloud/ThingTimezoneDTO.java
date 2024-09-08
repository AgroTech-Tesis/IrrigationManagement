package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ThingTimezoneDTO {
    private String name;
    private int offset;
    private String until;
}
