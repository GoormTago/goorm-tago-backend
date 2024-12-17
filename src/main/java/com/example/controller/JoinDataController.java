package com.example.controller;

import com.example.entity.JoinData;
import com.example.jpa.repository.JoinDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/view/join-data")
public class JoinDataController {

    @Autowired
    private JoinDataRepository joinDataRepository;

    @GetMapping
    public String getAllJoinData(Model model) {
        model.addAttribute("joinDataList", joinDataRepository.findAll());
        return "join-data-list";
    }

    @PostMapping("/add")
    public String addJoinData(@ModelAttribute JoinData joinData) {
        joinDataRepository.save(joinData);
        return "redirect:/api/view/join-data";
    }

    @PostMapping("/edit/{id}")
    public String updateJoinData(@PathVariable Long id, @ModelAttribute JoinData joinData) {
        joinData.setId(id);
        joinDataRepository.save(joinData);
        return "redirect:/api/view/join-data";
    }

    @GetMapping("/delete/{id}")
    public String deleteJoinData(@PathVariable Long id) {
        joinDataRepository.deleteById(id);
        return "redirect:/api/view/join-data";
    }
}
