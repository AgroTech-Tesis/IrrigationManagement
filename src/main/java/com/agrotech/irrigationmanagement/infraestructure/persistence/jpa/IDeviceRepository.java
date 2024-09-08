package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findAll();
    Device findDevicesByDeviceName(String name);
    List<Device> findAllByZoneId(Long zoneId);
}
