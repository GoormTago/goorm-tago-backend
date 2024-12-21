package io.goormtago.controller.view;

import io.goormtago.entity.TaxiReservation;
import io.goormtago.jpa.repository.TaxiReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/view/taxi-reservations")
public class TaxiReservationViewController {

    @Autowired
    private TaxiReservationRepository taxiReservationRepository;

    // 모든 예약 데이터 가져오기
    @GetMapping
    public String getAllTaxiReservations(Model model) {
        model.addAttribute("taxiReservations", taxiReservationRepository.findAll());
        return "taxi-reservation-list";
    }

    // 새로운 예약 추가
    @PostMapping("/add")
    public String addTaxiReservation(@ModelAttribute TaxiReservation taxiReservation) {
        taxiReservationRepository.save(taxiReservation);
        return "redirect:/api/view/taxi-reservations";
    }

    // 예약 데이터 수정
    @PostMapping("/edit/{id}")
    public String updateTaxiReservation(@PathVariable Long id, @ModelAttribute TaxiReservation taxiReservation) {
        taxiReservation.setId(id);
        taxiReservationRepository.save(taxiReservation);
        return "redirect:/api/view/taxi-reservations";
    }

    // 예약 데이터 삭제
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteTaxiReservation(@PathVariable Long id) {
        taxiReservationRepository.deleteById(id);
        return "Deleted successfully!";
    }
}
