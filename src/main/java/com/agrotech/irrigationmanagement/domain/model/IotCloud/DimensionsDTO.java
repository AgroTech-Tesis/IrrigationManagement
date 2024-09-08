package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DimensionsDTO {
    private int width;
    private int height;
    private int widthMobile;
    private int heightMobile;
    private int x;
    private int xMobile;
    private int y;
    private int yMobile;
}
