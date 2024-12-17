package com.example.controller;

import com.example.entity.TaxiReservation;
import com.example.jpa.repository.TaxiReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/view/taxi-reservations")
public class TaxiReservationController {

    @Autowired
    private TaxiReservationRepository taxiReservationRepository;

    @GetMapping
    public String getAllTaxiReservations(Model model) {
        model.addAttribute("taxiReservations", taxiReservationRepository.findAll());
        return "taxi-reservation-list";
    }

    @PostMapping("/add")
    public String addTaxiReservation(@ModelAttribute TaxiReservation taxiReservation) {
        taxiReservationRepository.save(taxiReservation);
        return "redirect:/api/view/taxi-reservations";
    }

    @PostMapping("/edit/{id}")
    public String updateTaxiReservation(@PathVariable Long id, @ModelAttribute TaxiReservation taxiReservation) {
        taxiReservation.setId(id);
        taxiReservationRepository.save(taxiReservation);
        return "redirect:/api/view/taxi-reservations";
    }

    @GetMapping("/delete/{id}")
    public String deleteTaxiReservation(@PathVariable Long id) {
        taxiReservationRepository.deleteById(id);
        return "redirect:/api/view/taxi-reservations";
    }
}
