package com.agrotech.irrigationmanagement.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SensorDataRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "tx_last_value")
    private Float lastValue;
    @Column(name = "type_sensor", length = 60)
    private String typeSensor;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public SensorDataRecord(LocalDateTime localDateTime, Float aFloat, String s) {
    }
}
