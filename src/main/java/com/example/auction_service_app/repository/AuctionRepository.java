package com.example.auction_service_app.repository;


import com.example.auction_service_app.model.AuctionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionModel,Long> {
}
