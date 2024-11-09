package com.agrotech.irrigationmanagement.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataRecordAverage {
    private Double flowSensor;
    private Double humiditySensor;
    private Double temperatureSensor;
    private Double humidityRelativeSensor;
}
