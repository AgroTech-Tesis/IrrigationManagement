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
public class Actuator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tx_name", length = 40)
    private String name;
    @Column(name = "tx_model", length = 40)
    private String model;
    @Column(name = "tx_code", length = 40)
    private String code;
    @Column(name = "tx_is_on")
    private Boolean isOn;
    @Column(name = "tx_created_at")
    private LocalDateTime createdAt;
    @Column(name = "tx_update_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}
