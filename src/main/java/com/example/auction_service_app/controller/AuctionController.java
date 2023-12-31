package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.CategoryModel;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auctions")
public class AuctionController {

    private final AuctionService auctionService;
    private final CategoryService categoryService;
    private final BiddingService biddingService;
    private final UserService userService;

    @GetMapping("/")
    public String getAllActiveAuctions(Model model) {
        List<AuctionModel> auctions = auctionService.getAllActiveAuctions();

        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions"; // zwraca nazwę widoku, np. "auctions.html"
    }

    @GetMapping("/all")
    public String getAllAuctions(Model model) {
        List<AuctionModel> auctions = auctionService.getAllAuctions();
        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions"; // zwraca nazwę widoku, np. "auctions.html"
    }

    @GetMapping("/auctionDetails/{id}")
    public String getSingleAuction(@PathVariable Long id, Model auctionModel, Model biddingModel) {
        auctionModel.addAttribute("singleAuction", auctionService.getAuctionById(id));
        biddingModel.addAttribute("bidding", biddingService.getAuctionBiddings(id));
        return "auctions/detailsAuction";
    }

    @GetMapping("/addAuction")
    public String getAddUser(Model model) {
        List<CategoryModel> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "auctions/addNewAuction";
    }

    @PostMapping("/addAuction")

    public RedirectView postAuction(AuctionModel auction, Principal principal) {
        if(auctionService.processAuction(auction, principal)){
            return new RedirectView("/auctions/");
        }
        else{
            return new RedirectView("/auctions/addAuction");
        }


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

    @GetMapping("/placeBid")
    public String showPlaceBidForm(Model model, @RequestParam("auctionId") Long auctionId) {
        model.addAttribute("auctionId", auctionId);
        return "auctions/placeBid";  // zwraca widok formularza do składania ofert
    }

    @ModelAttribute("currentUser")
    public UserModel getCurrentUser(UserModel userModel) {
        // zakładając, że nazwa użytkownika (login) jest używana jako "principal" w kontekście Spring Security
        return userService.findByAccountName(userModel.getAccountName());
    }

    @GetMapping("/my")
    public String getAllUserAuctions(Model model, Principal principal) {
        List<AuctionModel> auctions = auctionService.getAllUserAuctions(principal);
        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions"; // zwraca nazwę widoku, np. "auctions.html"
    }

    @PostMapping("/auctionDetails/{id}")
    public String buyNow(@PathVariable Long id, Principal principal) {
        auctionService.buyAuctionWithBuyNowButton(id, principal);
        return "auctions/listAuctions";
    }

    @GetMapping("/detailSearch")
    public String getDetailSearch() {
        return "auctions/detailSearch";
    }

    @PostMapping("/detailSearch")
    public String postDetailSearch(String city, String voievodeship, Long sortDateType, Long buyNow, Model model) {

        List<AuctionModel> auctions = auctionService.getFilteredAuctions(city, voievodeship, sortDateType, buyNow);
        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions";
    }
    @PostMapping("/observeAuction")
    public String observeAuction(Long auctionId, Principal principal) {
        auctionService.observeAuction(principal, auctionId);  // tutaj używamy instancji, nie klasy
        return "redirect:/path_to_auction_list";
    }

    @GetMapping("/observedAuctions")
    public String showObservedAuctions(Model model, Principal principal) {
        List<AuctionModel> observedAuctions = auctionService.getObservedAuctions(principal);  // tu też
        model.addAttribute("auctions", observedAuctions);
        return "observedAuctionsView";
    }



    @GetMapping("/buyed")
    public String getBuyedUserAuctions(Model model, Principal principal) {
        List<AuctionModel> auctions = auctionService.getBuyedUserAuctions(principal);
        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions"; // zwraca nazwę widoku, np. "auctions.html"
    }

}


