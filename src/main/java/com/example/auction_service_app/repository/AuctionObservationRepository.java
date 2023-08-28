package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.AuctionObservationModel;
import com.example.auction_service_app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionObservationRepository extends JpaRepository<AuctionObservationModel, Long> {
    AuctionObservationModel findByUserModel(UserModel user);
}