package com.agrotech.irrigationmanagement.infraestructure.persistence.jpa;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Notification;
import feign.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query("SELECT n FROM Notification n ORDER BY n.id DESC")
    List<Notification> getPagination(Pageable pageable);

    @Query("SELECT n FROM Notification n WHERE n.createdAt BETWEEN :startDate AND :endDate ORDER BY n.id DESC")
    List<Notification> getPaginationByDateRange(@Param("startDate") LocalDateTime startDate,
                                                @Param("endDate") LocalDateTime endDate,
                                                Pageable pageable);

}
