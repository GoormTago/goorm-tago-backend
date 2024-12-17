package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import com.example.jpa.repository.UserRepository;

@Controller
public class MainController {
	
	private final UserRepository userRepository;
	
	public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@GetMapping("/api")
	public String Main() {
		return "redirect:/sample"; 
	}

	// 사용자 리스트 표시 sample
	@GetMapping("/api/sample")
	public String samplePage(Model model) {
		model.addAttribute("users", userRepository.findAll());
        return "index"; // index.html 템플릿 반환
	}
	
	// 사용자 필요정보 샘플데이터 전달
	@GetMapping("/api/sampledatas")
	public String samplePage() {
		
        return "index"; // index.html 템플릿 반환
	}



}
