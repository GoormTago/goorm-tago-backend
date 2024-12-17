package com.example.controller;

import com.example.entity.MatchingData;
import com.example.jpa.repository.MatchingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/view/matching-data")
public class MatchingDataController {

    @Autowired
    private MatchingDataRepository matchingDataRepository;

    @GetMapping
    public String getAllMatchingData(Model model) {
        model.addAttribute("matchingDataList", matchingDataRepository.findAll());
        return "matching-data-list";
    }

    @PostMapping("/add")
    public String addMatchingData(@ModelAttribute MatchingData matchingData) {
        matchingDataRepository.save(matchingData);
        return "redirect:/api/view/matching-data";
    }

    @PostMapping("/edit/{id}")
    public String updateMatchingData(@PathVariable Long id, @ModelAttribute MatchingData matchingData) {
        matchingData.setId(id);
        matchingDataRepository.save(matchingData);
        return "redirect:/api/view/matching-data";
    }

    @GetMapping("/delete/{id}")
    public String deleteMatchingData(@PathVariable Long id) {
        matchingDataRepository.deleteById(id);
        return "redirect:/api/view/matching-data";
    }
}
