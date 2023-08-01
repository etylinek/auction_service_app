package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.AuctionObservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionObservationRepository extends JpaRepository<AuctionObservation, Long> {
}