package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISensorDataRecordRepository extends JpaRepository<SensorDataRecord, Long> {
    @Query("SELECT s FROM SensorDataRecord s " +
    "INNER JOIN Sensor a on a.id = s.sensor.id " +
    "INNER JOIN Device d on d.id = a.device.id " +
    "INNER JOIN Zone z on z.id = d.zone.id " +
    "WHERE (s.createdAt >= DATE(:startDate) or :startDate is null) " +
    "AND (s.createdAt <= DATE(:endDate) or :endDate is null) " +
    "AND (s.typeSensor = :typeSensor or :typeSensor is null) " +
    "AND (z.id = :zoneId or :zoneId is null)")
    List<SensorDataRecord> getPagination(String startDate, String endDate, String zoneId, String typeSensor);
}
