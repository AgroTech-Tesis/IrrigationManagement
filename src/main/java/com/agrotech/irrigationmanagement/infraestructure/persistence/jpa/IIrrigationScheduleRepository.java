package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.IrrigationSchedule;
import com.agrotech.irrigationmanagement.domain.model.queries.GetAllIrrigationScheduleByRiceCropIdQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IIrrigationScheduleRepository extends JpaRepository<IrrigationSchedule, Long> {
    List<IrrigationSchedule> findAll();

    @Query("SELECT s " +
            "FROM IrrigationSchedule s " +
            "INNER JOIN RiceCrop r on r.id = s.riceCrop.id " +
            "WHERE (s.status = :status or :status is null) AND r.id = :id")
    List<IrrigationSchedule> findAllByRiceCropIdAndStatus(Long id, String status);
    IrrigationSchedule getIrrigationScheduleById(Long id);
}
