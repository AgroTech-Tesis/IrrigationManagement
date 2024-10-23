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
public class RiceCrop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 40)
    private String name;
    @Column(name = "status", length = 40)
    private String status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
    @Column(name = "farmer_id")
    private Long farmerId;

    @OneToMany(mappedBy = "riceCrop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zone> zones;
    @OneToMany(mappedBy = "riceCrop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Irrigation> irrigation;

    public RiceCrop(Long id, String name, String status, LocalDateTime createdAt, LocalDateTime updatedAt, Long farmerId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.farmerId = farmerId;
    }
}
