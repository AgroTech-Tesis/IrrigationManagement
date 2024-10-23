package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IIrrigationRepository extends JpaRepository<Irrigation, Long> {
    List<Irrigation> findAll();
    Irrigation getFirstByRiceCropIdAndStatus(Long riceCropId, String status);
    Irrigation findIrrigationEntitiesById(Long id);

}
