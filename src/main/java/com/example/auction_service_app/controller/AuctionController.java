package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auctions")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

        @GetMapping
        public String getAllAuctions(Model model) {
            List<AuctionModel> auctions = auctionService.getAllAuctions();
            model.addAttribute("auctions", auctions);
            return "auctions"; // zwraca nazwę widoku, np. "auctions.html"
        }

        // ...
    }