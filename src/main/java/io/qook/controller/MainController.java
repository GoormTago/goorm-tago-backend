package io.qook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.qook.jpa.repository.UserRepository;

@Controller
public class MainController {
	
	private final UserRepository userRepository;
	
	public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@GetMapping("/")
	public String Main() {
		return "redirect:/users/sample"; 
	}

	@GetMapping("/test")
	public String apiTest() {
		return "api";
	}
	
	@GetMapping("/api")
	public String apiTest2() {
		return "api";
	}
	
	// 사용자 리스트 표시 sample
	@GetMapping("/sample")
	public String samplePage(Model model) {
		model.addAttribute("users", userRepository.findAll());
        return "index"; // index.html 템플릿 반환
	}



}
