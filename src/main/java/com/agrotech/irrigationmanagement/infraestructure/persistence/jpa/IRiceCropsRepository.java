package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;


import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRiceCropsRepository extends JpaRepository<RiceCrop, Long> {
    List<RiceCrop> findAll();
    RiceCrop findByFarmerIdAndStatus(Long farmerId, String status);
}
