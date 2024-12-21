package io.goormtago.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.goormtago.jpa.repository.UserRepository;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	
	private final UserRepository userRepository;
	
	public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@GetMapping("/api")
	public String Main() {
		return "index"; 
	}

}
