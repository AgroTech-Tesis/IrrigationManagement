package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDeviceRepository extends JpaRepository<Device, Long> {
    @Query("SELECT d FROM Device d " +
            "JOIN d.zone z " +
            "JOIN z.riceCrop rc " +
            "WHERE rc.id = :riceCropId")
    List<Device> findByRiceCropId(@Param("riceCropId") Long riceCropId);

    Device findDevicesByDeviceName(String name);
    Device findDevicesById(Long id);
    List<Device> findAllByZoneId(Long zoneId);
}
