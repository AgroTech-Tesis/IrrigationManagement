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
public class Irrigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tx_created_at")
    private LocalDateTime createdAt;
    @Column(name = "tx_update_at")
    private LocalDateTime updatedAt;
    @Column(name = "tx_ended_at")
    private LocalDateTime endedAt;
    @Column(name = "tx_water_amount")
    private Double waterAmount;
    @Column(name = "tx_irrigation_number")
    private Integer irrigationNumber;
    @Column(name = "tx_days_previous_irrigation")
    private Integer daysPreviousIrrigation;
    @Column(name = "tx_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "rice_crop_id")
    private RiceCrop riceCrop;

    public Irrigation(Long id, LocalDateTime localDateTime, LocalDateTime localDateTime1, LocalDateTime localDateTime2, Double aDouble, Integer integer, Integer integer1, String status) {
    }
}
