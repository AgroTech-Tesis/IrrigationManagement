package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findAll();
    Sensor findSensorByName(String name);
}
