package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.IrrigationSchedule;
import com.agrotech.irrigationmanagement.domain.model.queries.GetAllIrrigationScheduleByRiceCropIdQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IIrrigationScheduleRepository extends JpaRepository<IrrigationSchedule, Long> {
    List<IrrigationSchedule> findAll();
    List<IrrigationSchedule> findAllByRiceCropId(Long id);
    IrrigationSchedule getIrrigationScheduleById(Long id);
}
