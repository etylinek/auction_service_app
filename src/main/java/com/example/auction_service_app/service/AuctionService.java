package com.example.auction_service_app.service;

import com.example.auction_service_app.model.*;
import com.example.auction_service_app.repository.AuctionObservationRepository;
import com.example.auction_service_app.repository.AuctionRepository;
import com.example.auction_service_app.repository.BiddingRepository;
import com.example.auction_service_app.repository.CategoryRepository;
import com.example.auction_service_app.types.AuctionStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionService {


    private final AuctionRepository auctionRepository;

    private final AuctionObservationRepository auctionObservationRepository;

    private final CategoryRepository categoryRepository;

    private final BiddingRepository biddingRepository;


    public List<AuctionModel> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public List<AuctionModel> getAllActiveAuctions(){
        return auctionRepository.findAllByAuctionStatusType(AuctionStatusType.ACTIVE);
    }
    public List<AuctionModel> getAuctionsByUser(UserModel user) { // 1.4 Prezentacja listy aukcji (zalogowanego) usera
       return auctionRepository.findByUserModel(user);
//        return List.of();
    }
    public List<BiddingModel> getBiddingsByUser(UserModel user){
        return biddingRepository.findByUserModel(user);
 //       return List.of();
    }
    public List<AuctionObservationModel> getObservedAuctionsByUser(UserModel user){
         return auctionObservationRepository.findByUserModel(user);
 //       return List.of();
    }

    public void addAuction(AuctionModel auction){
        auctionRepository.save(auction);
    }


    public void deleteAuction(Long id) {
        auctionRepository.deleteById(id);
    }

    public List<AuctionModel> searchAuctions(String name) {
        // Tu logika do wyszukiwania aukcji na podstawie nazwy aukcji.
        return auctionRepository.findByNameContainingIgnoreCase(name);
    }
    public List<AuctionModel> getAuctionsByCategory(CategoryModel categoryModel) {
        // Tu logika do wyszukiwania aukcji na podstawie kategorii.
        return auctionRepository.findByCategoryModel(categoryModel);
    }



    /*public List<AuctionModel> getAuctionsByUser(UserModel user) { //opcjonalna metoda do znajdywania użytkownika po statusie zalogowania
        if (user.getAccountStatus() != AccountStatus.ACTIVE) {
            return Collections.emptyList(); // zwraca pustą listę
        }

        return auctionRepository.findByUser(user);
    }*/

 /*   public AuctionModel getAuctionById(Long id) {
        return auctionRepository.findById(id)
                .orElseThrow(() -> new AuctionNotFoundException("Auction not found with ID: " + id));
    }*/

/*    public List<AuctionModel> getAuctionsByCategory(Long categoryId) {
        CategoryModel category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + categoryId));
        return auctionRepository.findByCategory(category);
    }*/

    public AuctionModel createAuction(AuctionModel auctionModel) {
        // Optionally you can validate and set other attributes here
        return auctionRepository.save(auctionModel);
    }

/*    public AuctionModel updateAuction(Long id, AuctionModel auctionModel) {
        AuctionModel existingAuction = getAuctionById(id);
        // Update the existing auction attributes with the provided model
        // You may want to be more selective about what can be updated
        BeanUtils.copyProperties(auctionModel, existingAuction, "id");
        return auctionRepository.save(existingAuction);
    }*/

 /*   public void deleteAuction(Long id) {
        AuctionModel existingAuction = getAuctionById(id);
        auctionRepository.delete(existingAuction);
    }*/
}