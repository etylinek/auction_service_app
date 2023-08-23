package com.example.auction_service_app.controller;


import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class UserRegisterController {

    private final UserService userService;

    @GetMapping("/")
    public String getAddUser(){
        return "auth/register";
    }

    @PostMapping("/")
    public RedirectView postUser(UserModel user){
        userService.addUser(user);
        return new RedirectView("/login/");
    }


}
