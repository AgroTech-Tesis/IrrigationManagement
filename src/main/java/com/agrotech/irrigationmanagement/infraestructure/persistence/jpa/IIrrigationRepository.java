package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IIrrigationRepository extends JpaRepository<Irrigation, Long> {
    List<Irrigation> findAll();
    @Query("SELECT i FROM Irrigation i WHERE i.riceCrop.id = :riceCropId ORDER BY i.createdAt DESC LIMIT 1")
    List<Irrigation> findAllByRiceCropId(Long riceCropId);
    Irrigation findIrrigationEntitiesById(Long id);

}
