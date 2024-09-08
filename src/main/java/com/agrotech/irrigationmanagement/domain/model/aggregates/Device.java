package com.agrotech.irrigationmanagement.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "device_name", length = 40)
    private String deviceName;
    @Column(name = "device_model", length = 40)
    private String deviceModel;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
    @Column(name = "is_on", length = 40)
    private String isOn;
    @Column(name = "status")
    private String status;
    @Column(name = "media", length = 40)
    private String media;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actuator> actuators;
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sensor> sensors;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    public Device(Long id, String deviceName, String deviceModel, LocalDateTime localDateTime, LocalDateTime localDateTime1, String on, String status, String media) {
    }
}
