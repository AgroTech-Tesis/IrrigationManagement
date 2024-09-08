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
    @Column(name = "name", length = 40)
    private String name;
    @Column(name = "model", length = 40)
    private String model;
    @Column(name = "code", length = 40)
    private String code;
    @Column(name = "is_on")
    private Boolean isOn;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}
