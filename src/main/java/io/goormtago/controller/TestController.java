package io.goormtago.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @GetMapping("/api/db-url")
    public String getDatabaseUrl() {
        return "Database URL: " + databaseUrl;
    }
}