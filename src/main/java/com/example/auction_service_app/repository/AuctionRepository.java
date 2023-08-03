package com.example.auction_service_app.repository;


import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionModel,Long> {
    List<AuctionModel> findByUserModel(UserModel user); // Potrzebne do punktu 1.4 prezentacja listy aukcji usera (alternatywnie może być zalogowanego)
}
