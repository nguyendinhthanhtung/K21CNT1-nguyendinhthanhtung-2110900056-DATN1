package com.example.doantotnghiep_nguyendinhthanhtung.Repository;

import com.example.doantotnghiep_nguyendinhthanhtung.Entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailsEntity, Long> {
    @Query("select od from OrderDetailsEntity od WHERE od.orderId.id = :orderId")
    List<OrderDetailsEntity> findByOrderId(@Param("orderId") Long orderId);
}
