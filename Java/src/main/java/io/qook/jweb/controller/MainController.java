package io.qook.jweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
    public String Main() {
        return "redirect:/users"; 
    }
	
	@GetMapping("/api/test")
    public String apiTest() {
        return "api"; 
    }
	@GetMapping("/api/db")
    public String apiTestDB() {
        return "api"; 
    }
	
	
}
