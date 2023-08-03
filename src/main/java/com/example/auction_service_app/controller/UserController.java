package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.AuctionObservation;
import com.example.auction_service_app.model.Bidding;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String getAddUser(){
        return "user/addNewUser";
    }

    @PostMapping("/addUser")
    public RedirectView postUser(UserModel user){
        userService.addUser(user);
        return new RedirectView("/users");
    }


   /* @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }*/

  /*  @GetMapping("/my-auctions")
    public List<AuctionModel> getUserAuctions(Principal principal) {
        return userService.getAuctionsByUserEmail(principal.getName());
    }*/

 /*   @GetMapping("/my-biddings")
    public List<Bidding> getUserBiddings(Principal principal) {
        return userService.getBiddingsByUserEmail(principal.getName());
    }*/

 /*   @GetMapping("/observed-auctions")
    public List<AuctionObservation> getObservedAuctions(Principal principal) {
        return userService.getObservedAuctionsByUserEmail(principal.getName());
    }*/
}