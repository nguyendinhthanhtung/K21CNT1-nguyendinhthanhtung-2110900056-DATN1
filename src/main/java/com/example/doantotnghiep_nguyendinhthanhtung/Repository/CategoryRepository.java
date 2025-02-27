package com.example.doantotnghiep_nguyendinhthanhtung.Repository;

import com.example.doantotnghiep_nguyendinhthanhtung.Entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository cho thực thể CategoryEntity, xử lý truy vấn dữ liệu liên quan đến danh mục.
 * Kế thừa JpaRepository để sử dụng các phương thức CRUD có sẵn.
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    /**
     * Truy vấn danh sách danh mục theo tên với tìm kiếm gần đúng (LIKE %name%).
     * Sử dụng @Query để viết câu lệnh JPQL.
     *
     * @param name     Tên danh mục cần tìm kiếm (tìm kiếm không chính xác).
     * @param pageable Đối tượng phân trang giúp chia nhỏ kết quả.
     * @return         Danh sách các danh mục phù hợp dưới dạng Page.
     */
    @Query("SELECT c FROM CategoryEntity c WHERE c.name LIKE %:name%")
    Page<CategoryEntity> findByName(@Param("name") String name, Pageable pageable);
}
