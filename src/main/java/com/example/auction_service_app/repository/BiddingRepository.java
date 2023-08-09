package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.BiddingModel;
import com.example.auction_service_app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BiddingRepository extends JpaRepository<BiddingModel, Long> {
    List<BiddingModel> findByUserModel(UserModel user);

}
