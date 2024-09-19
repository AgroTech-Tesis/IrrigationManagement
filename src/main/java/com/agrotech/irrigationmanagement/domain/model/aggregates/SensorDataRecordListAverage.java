package com.agrotech.irrigationmanagement.domain.model.aggregates;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
public class SensorDataRecordListAverage {
    private Long id;
    private LocalDateTime createdAt;
    private Float lastValue;
    private String typeSensor;
    private Long sensorId;
    private String deviceId;
    private String name;

    public SensorDataRecordListAverage(Long id, LocalDateTime createdAt, Float lastValue, String typeSensor, Long sensorId, String deviceId, String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.lastValue = lastValue;
        this.typeSensor = typeSensor;
        this.sensorId = sensorId;
        this.deviceId = deviceId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Float getLastValue() {
        return lastValue;
    }

    public String getTypeSensor() {
        return typeSensor;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getName() {
        return name;
    }
}
