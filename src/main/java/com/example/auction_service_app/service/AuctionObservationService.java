package com.example.auction_service_app.service;

import com.example.auction_service_app.model.AuctionObservation;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.repository.AuctionObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionObservationService {

    @Autowired
    private AuctionObservationRepository auctionObservationRepository;

   /* public List<AuctionObservation> getObservedAuctionsByUser(UserModel user) {
        return auctionObservationRepository.findByUser(user);
    }*/
}