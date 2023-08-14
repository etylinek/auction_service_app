package com.example.auction_service_app.controller;

import com.example.auction_service_app.dto.BidRequest;
import com.example.auction_service_app.exception.BidTooLowException;
import com.example.auction_service_app.service.BiddingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auctions")
public class BiddingController {
   private final BiddingService biddingService;

    public BiddingController(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

   /* @PostMapping("/{auctionId}/bid")
    public ResponseEntity<String> placeBid(@PathVariable Long auctionId, @RequestBody BidRequest bidRequest) {
        try {
            biddingService.placeBid(auctionId, bidRequest);
            return ResponseEntity.ok("Twoja oferta została pomyślnie wysłana");
        } catch (BidTooLowException e) {
            return ResponseEntity.badRequest().body("Twoja kwota jest zbyt niska");
        }
    }*/

    /*@PostMapping("/{auctionId}/buyNow")
    public ResponseEntity<String> buyNow(@PathVariable Long auctionId) {
        biddingService.buyNow(auctionId);
        return ResponseEntity.ok("Auction bought successfully");
    }*/
}
