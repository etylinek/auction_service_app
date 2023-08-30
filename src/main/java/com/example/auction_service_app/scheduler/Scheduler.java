package com.example.auction_service_app.scheduler;


import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.repository.AuctionRepository;
import com.example.auction_service_app.service.AuctionService;
import com.example.auction_service_app.types.AuctionStatusType;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class Scheduler {


    private final AuctionService auctionService;
    @Scheduled(fixedRate = 1000)
    public void checkActiveAuctions() {

        List<AuctionModel> auctionModels = auctionService.getAllActiveAuctions();

        for (AuctionModel a : auctionModels) {
            if (a.getEndDate().isAfter(LocalDateTime.now())) {
                a.setAuctionStatusType(AuctionStatusType.ENDED);
                auctionService.addAuction(a);
            }
        }
    }


}
