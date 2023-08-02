package com.example.auction_service_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // zwraca nazwę widoku strony głównej (np. "home.html" w katalogu templates, jeśli używasz Thymeleaf)
    }

    // Inne ogólne metody, jeśli są potrzebne
}