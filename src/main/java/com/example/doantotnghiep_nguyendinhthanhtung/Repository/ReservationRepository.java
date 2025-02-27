package com.example.doantotnghiep_nguyendinhthanhtung.Repository;

import com.example.doantotnghiep_nguyendinhthanhtung.Entity.ReservationsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationsEntity, Long> {
    @Query("select r from ReservationsEntity r WHERE r.userId.id = :userId ")
    Page<ReservationsEntity> findByCustomerId(@Param("userId") Long userId, Pageable pageable);
}
