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
    @Column(name = "tx_name", length = 40)
    private String name;
    @Column(name = "tx_status", length = 40)
    private String status;
    @Column(name = "tx_created_at")
    private LocalDateTime createdAt;
    @Column(name = "tx_update_at")
    private LocalDateTime updatedAt;
    @Column(name = "tx_farmer_id")
    private Long farmerId;

    @OneToMany(mappedBy = "riceCrop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zone> zones;
    @OneToMany(mappedBy = "riceCrop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Irrigation> irrigation;

    public RiceCrop(Long id, String name, String status, LocalDateTime localDateTime, LocalDateTime localDateTime1, Long aLong) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = localDateTime;
        this.updatedAt = localDateTime1;
        this.farmerId = aLong;
    }
}
