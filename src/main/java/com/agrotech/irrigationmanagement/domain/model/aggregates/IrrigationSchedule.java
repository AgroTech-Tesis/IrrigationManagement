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
public class IrrigationSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tx_irrigatio_time", length = 40)
    private Float irrigationTime;
    @Column(name = "tx_irrigation_date", length = 40)
    private LocalDateTime irrigationDate;
    @Column(name = "tx_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "rice_crop_id")
    private RiceCrop riceCrop;

    public IrrigationSchedule(Long id, Float irrigationTime, LocalDateTime irrigationDate, String name) {
        this.id = id;
        this.irrigationTime = irrigationTime;
        this.irrigationDate = irrigationDate;
        this.name = name;
    }
}
