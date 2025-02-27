package com.example.doantotnghiep_nguyendinhthanhtung.Repository;

import com.example.doantotnghiep_nguyendinhthanhtung.Entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("select o from OrderEntity o WHERE o.userId.id = :userId")
    Page<OrderEntity> findByUserIdDesc(@Param("userId") Long userId, Pageable pageable);
}
