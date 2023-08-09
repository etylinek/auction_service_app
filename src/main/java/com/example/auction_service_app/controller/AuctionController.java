package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auctions")
public class AuctionController {

    private final AuctionService auctionService;

        @GetMapping("/")
        public String getAllAuctions(Model model) {
            List<AuctionModel> auctions = auctionService.getAllAuctions();
            model.addAttribute("auctions", auctions);
            return "auctions"; // zwraca nazwę widoku, np. "auctions.html"
        }

    @PostMapping("/addAuction")
    public RedirectView postAuction(AuctionModel auction){
        auctionService.addAuction(auction);
        return new RedirectView("/");
    }







    @PostMapping("/deleteAuction/{id}")
    public RedirectView deleteAuction(@PathVariable Long id) {
        auctionService.deleteAuction(id);
        return new RedirectView("/auctions/");
    }































        // ...
    }