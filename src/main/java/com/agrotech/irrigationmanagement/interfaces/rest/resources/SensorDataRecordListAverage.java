package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataRecordListAverage {
    private Long id;
    private LocalDateTime createdAt;
    private Float lastValue;
    private String typeSensor;
    private Long sensorId;
    private String deviceName;
    private String name;
}
