package com.example.auction_service_app.controller;


import com.example.auction_service_app.service.BiddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("bidding")
public class BiddingController {

    private final BiddingService biddingService;

    @PostMapping("/placeBid/{auctionId}")
    public String placeBid(@PathVariable Long auctionId, Long proposedValue, Principal principal) {

        return biddingService.placeBid(auctionId, proposedValue, principal);
    }


}
