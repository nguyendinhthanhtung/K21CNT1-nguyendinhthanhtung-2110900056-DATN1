package com.example.doantotnghiep_nguyendinhthanhtung.Controller.Admin;

import com.example.doantotnghiep_nguyendinhthanhtung.Entity.ReservationsEntity;
import com.example.doantotnghiep_nguyendinhthanhtung.Repository.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/dan-ban")
public class ReservationController {
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public String admin(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "20") int size) {
        // Lấy danh sách món ăn theo tiêu chí tìm kiếm
        Page<ReservationsEntity> reservations = reservationRepository.findAll(PageRequest.of(page, size));

        model.addAttribute("reservations", reservations.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", Math.max(reservations.getTotalPages(), 1));
        return "Admin/Reservations/list";
    }

    @GetMapping("/detail/{id}")
    public String admin(Model model,
                        @PathVariable Long id) {
        // Lấy danh sách món ăn theo tiêu chí tìm kiếm
      ReservationsEntity reservations = reservationRepository.findById(id).get();

        model.addAttribute("reservation", reservations);

        return "admin/dan-ban";
    }

    /**
     * Hiển thị trang chỉnh sửa món ăn.
     */
    @GetMapping("/edit/{id}")
    public String editMenu(@PathVariable Long id, Model model) {
        ReservationsEntity reservations = reservationRepository.findById(id).get();
        model.addAttribute("reservation", reservations);
        return "Admin/Reservations/edit";
    }

    /**
     * Xử lý cập nhật thông tin món ăn.
     */
    @PostMapping("/edit/{id}")
    public String editMenu(@PathVariable Long id, @ModelAttribute ReservationsEntity reservationsEntity, Model model) {
        try {
            ReservationsEntity reservations = reservationRepository.findById(id).get();
            reservations.setStatus(reservationsEntity.getStatus());
            reservationRepository.save(reservations);
            return "redirect:/admin/dan-ban";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "Admin/Reservations/edit";
        }
    }
}
