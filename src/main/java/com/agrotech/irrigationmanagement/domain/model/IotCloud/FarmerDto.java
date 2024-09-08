package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class FarmerDto {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
}
