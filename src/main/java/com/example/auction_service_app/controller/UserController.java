package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;





    @GetMapping("/showUser/")
    public String getShowUser(Principal principal, Model model) {

        UserModel userById = userService.getUserByPrincipal(principal);
        model.addAttribute("user", userById);
        return "users/detailsUser";
    }

    @GetMapping("/editUser/")
    public String getEditUser(Principal principal, Model model) {
        UserModel userById = userService.getUserByPrincipal(principal);
        model.addAttribute("user", userById);
        return "users/editUser";
    }

    @PostMapping("/editUser/")
    public RedirectView postEditUser(UserModel editUser) {
        userService.editUser(editUser);
        return new RedirectView("../showUser/");
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