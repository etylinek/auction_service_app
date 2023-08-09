package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.CategoryModel;
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
            return "auctions/listAuctions"; // zwraca nazwę widoku, np. "auctions.html"
        }


    @GetMapping("/addAuction")
    public String getAddUser(){
        return "auctions/addNewAuction";
    }

    @PostMapping("/addAuction")
    public RedirectView postAuction(AuctionModel auction){
        auctionService.addAuction(auction);
        return new RedirectView("/auctions/addAuction");
    }




    @PostMapping("/deleteAuction/{id}")
    public RedirectView deleteAuction(@PathVariable Long id) {
        auctionService.deleteAuction(id);
        return new RedirectView("/auctions/");
    }

    // Metoda do wyszukiwania aukcji na podstawie słowa kluczowego.
    @GetMapping("/search")
    public String searchAuctions(@RequestParam("name") String name, Model model) {
        List<AuctionModel> auctions = auctionService.searchAuctions(name);
        model.addAttribute("auctions", auctions);
        return "auctions/results"; // zwraca widok z wynikami wyszukiwania
    }

    // Metoda do prezentowania aukcji na podstawie kategorii.
    @GetMapping("/category")
    public String getAuctionsByCategory(@RequestParam("catName") CategoryModel categoryModel, Model model) {
        List<AuctionModel> auctions = auctionService.getAuctionsByCategory(categoryModel);
        model.addAttribute("auctions", auctions);
        return "auctions/results"; // zwraca ten sam widok, co wyszukiwanie, ale tym razem na podstawie kategorii
    }



    }