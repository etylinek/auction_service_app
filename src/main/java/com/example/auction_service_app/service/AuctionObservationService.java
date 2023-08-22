package com.example.auction_service_app.service;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.AuctionObservationModel;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.repository.AuctionObservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuctionObservationService {

    private final AuctionObservationRepository auctionObservationRepository;




}
