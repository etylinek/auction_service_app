package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.BiddingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiddingRepository extends JpaRepository<BiddingModel, Long> {
}
