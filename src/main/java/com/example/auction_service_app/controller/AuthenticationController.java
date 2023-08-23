package com.example.auction_service_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class AuthenticationController {

        @GetMapping("/login")
        public String getLogin(){


            return "/auth/login";
        }


    }

