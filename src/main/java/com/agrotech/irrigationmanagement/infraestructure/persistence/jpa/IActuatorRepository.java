package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActuatorRepository extends JpaRepository<Actuator, Long> {
    List<Actuator> findAll();
    Actuator findActuatorsByName(String name);
}
