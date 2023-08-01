package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiddingRepository extends JpaRepository<Bidding, Long> {
}
