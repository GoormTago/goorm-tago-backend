package com.example.controller;

import com.example.entity.Notice;
import com.example.jpa.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/view/notice")
public class NoticeController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping
    public String getAllNotices(Model model) {
        model.addAttribute("notices", noticeRepository.findAll());
        return "notice-list";
    }

    @PostMapping("/add")
    public String addNotice(@ModelAttribute Notice notice) {
        noticeRepository.save(notice);
        return "redirect:/api/view/notice";
    }

    @PostMapping("/edit/{id}")
    public String updateNotice(@PathVariable Long id, @ModelAttribute Notice notice) {
        notice.setId(id);
        noticeRepository.save(notice);
        return "redirect:/api/view/notice";
    }

    @GetMapping("/delete/{id}")
    public String deleteNotice(@PathVariable Long id) {
        noticeRepository.deleteById(id);
        return "redirect:/api/view/notice";
    }
}
