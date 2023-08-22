package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.CategoryModel;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.service.AuctionService;
import com.example.auction_service_app.service.BiddingService;
import com.example.auction_service_app.service.CategoryService;
import com.example.auction_service_app.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
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
//    @GetMapping("/")
//    public String getObservedAuctions(Model model, User user) {
//        List<AuctionModel> auctions = auctionService.getObservedAuctions(user);
//        model.addAttribute("auctions", auctions);
//        return "auctions/listObservedAuctions"; // zwraca nazwę widoku, np. "auctions.html"
//    }

    @GetMapping("/all")
    public String getAllAuctions(Model model) {
        List<AuctionModel> auctions = auctionService.getAllAuctions();
        model.addAttribute("auctions", auctions);
        return "auctions/listAuctions"; // zwraca nazwę widoku, np. "auctions.html"
    }

    @GetMapping("/auctionDetails/{id}")
        public String getSingleAuction(@PathVariable Long id, Model model){
        model.addAttribute("singleAuction", auctionService.getAuctionById(id));
        return "auctions/detailsAuction";
    }

    @GetMapping("/addAuction")
    public String getAddUser(Model model) {
        List<CategoryModel> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "auctions/addNewAuction";
    }
    @PostMapping("/addAuction")
    public RedirectView postAuction(AuctionModel auction) {
        if (auction.getMinValue() != null && auction.getMinValue().compareTo(BigDecimal.ZERO) > 0) {
            // to jest licytacja
            categoryService.setAuctionToCategory(auction);
            biddingService.addBidding(auction);
        } else {
            // to jest zwykła aukcja
            categoryService.setAuctionToCategory(auction);
            auctionService.addAuction(auction);
        }
        return new RedirectView("/auctions/addAuction");
    }

/*    @PostMapping("/addAuction")
    public RedirectView postAuction(AuctionModel auction) {
        categoryService.setAuctionToCategory(auction);
        auctionService.addAuction(auction);

        return new RedirectView("/auctions/addAuction");
    }*/

//        return new RedirectView("/auctions/");
//
//    }



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

    @PostMapping("/placeBid")
    public String placeBid(
            @RequestParam("auctionId") Long auctionId,
            @RequestParam("proposedValue") BigDecimal proposedValue,
            @RequestParam(name = "userId", required = false) Long userId,  // userId można uzyskać również z kontekstu sesji lub zabezpieczeń, zamiast przekazywać go jako parametr
            RedirectAttributes redirectAttributes) {

        boolean success = biddingService.placeBid(auctionId, proposedValue, userId);

        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "Twoja oferta została pomyślnie złożona.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Nie udało się złożyć oferty. Sprawdź wprowadzone dane i spróbuj ponownie.");
        }

        return "redirect:/auctions/placeBid?auctionId=" + auctionId;  // przekierowuje z powrotem do formularza licytacji z komunikatem o powodzeniu lub niepowodzeniu
    }

    @ModelAttribute("currentUser")
    public UserModel getCurrentUser(Principal principal) {
        // zakładając, że nazwa użytkownika (login) jest używana jako "principal" w kontekście Spring Security
        return userService.findByAccountName(principal.getName());
    }
}


