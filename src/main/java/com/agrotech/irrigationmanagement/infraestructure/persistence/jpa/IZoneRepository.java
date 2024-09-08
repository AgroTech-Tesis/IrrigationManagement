package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IZoneRepository extends JpaRepository<Zone, Long> {
    List<Zone> findAll();
    List<Zone> findAllByRiceCropId(Long riceCropId);
    Zone findZoneEntitiesById(Long id);
    Zone findZonesByName(String name);
}
