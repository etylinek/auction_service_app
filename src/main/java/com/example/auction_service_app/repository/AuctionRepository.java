package com.example.auction_service_app.repository;


import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.CategoryModel;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.types.AuctionStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionModel,Long> {


   List<AuctionModel>findAllByAuctionStatusType(AuctionStatusType auctionStatusType);
    List<AuctionModel> findByUserModel(UserModel user); // Potrzebne do punktu 1.4 prezentacja listy aukcji usera (alternatywnie może być zalogowanego)

    // Uproszczony kod do wyszukiwania aukcji na podstawie słowa kluczowego.
    @Query("SELECT a FROM AuctionModel a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<AuctionModel> findByNameContainingIgnoreCase(String name);

    // Uproszczony kod do wyszukiwania aukcji na podstawie kategorii.
    List<AuctionModel> findByCategoryModel(CategoryModel categoryModel);


}
