package com.example.auction_service_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthenticationController {

    @GetMapping()
    public String getLogin() {
        return "/auth/login";
    }

    @GetMapping("/endSession")
    public String logoutUser() {
        return "auth/logout";
    }

    @GetMapping("/error")
    public String loginError() {
        return "auth/loginError";
    }

}

