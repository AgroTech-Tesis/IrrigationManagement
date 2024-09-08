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
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tx_title", length = 40)
    private String title;
    @Column(name = "tx_body", length = 40)
    private String body;
    @Column(name = "tx_created_at")
    private LocalDateTime createdAt;
}
