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
    @Column(name = "tx_device_name", length = 40)
    private String deviceName;
    @Column(name = "tx_device_model", length = 40)
    private String deviceModel;
    @Column(name = "tx_created_at")
    private LocalDateTime createdAt;
    @Column(name = "tx_update_at")
    private LocalDateTime updatedAt;
    @Column(name = "tx_is_on", length = 40)
    private String isOn;
    @Column(name = "tx_status")
    private String status;
    @Column(name = "tx_media", length = 40)
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
