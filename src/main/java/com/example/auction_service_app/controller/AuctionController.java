package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.CategoryModel;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.service.AuctionService;
import com.example.auction_service_app.service.CategoryService;
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

    private final CategoryService categoryService;

    @GetMapping("/")
    public String getAllAuctions(Model model) {
        List<AuctionModel> auctions = auctionService.getAllAuctions();
        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions"; // zwraca nazwę widoku, np. "auctions.html"
    }


    @GetMapping("/addAuction")
    public String getAddUser(Model model) {
        List<CategoryModel> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "auctions/addNewAuction";
    }

    @PostMapping("/addAuction")
    public RedirectView postAuction(AuctionModel auction) {
        categoryService.setAuctionToCategory(auction);
        auctionService.addAuction(auction);
        return new RedirectView("/auctions/addAuction");

    }


    @PostMapping("/deleteAuction/{id}")
    public RedirectView deleteAuction(@PathVariable Long id) {
        auctionService.deleteAuction(id);
        return new RedirectView("/auctions/");
    }

    // Metoda do wyszukiwania aukcji na podstawie słowa kluczowego.
    @PostMapping("/search")
    public String searchAuctions(String name, Model model) {
        List<AuctionModel> auctions = auctionService.searchAuctions(name);
        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions"; // zwraca widok z wynikami wyszukiwania
    }


    // Metoda do prezentowania aukcji na podstawie kategorii.
    @GetMapping("/category/{id}")
    public String getAuctionsByCategory(@PathVariable Long id, Model model) {

        List<AuctionModel> auctions = auctionService.getAuctionsByCategory(categoryService.getCategoryById(id));
        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions"; // zwraca ten sam widok, co wyszukiwanie, ale tym razem na podstawie kategorii
    }


}