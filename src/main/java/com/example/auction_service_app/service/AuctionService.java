package com.example.auction_service_app.service;

import com.example.auction_service_app.model.*;
import com.example.auction_service_app.repository.*;
import com.example.auction_service_app.types.AuctionStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.security.Principal;

import java.math.BigDecimal;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final UserRepository userRepository;

    private final AuctionRepository auctionRepository;

    private final AuctionObservationRepository auctionObservationRepository;

    private final CategoryRepository categoryRepository;

    private final BiddingRepository biddingRepository;

    private final BiddingService biddingService;

    private final CategoryService categoryService;


    public AuctionModel getAuctionById(Long id) {
        return auctionRepository.findById(id).orElse(null);
    }

    public List<AuctionModel> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public List<AuctionModel> getAllActiveAuctions() {
        return auctionRepository.findAllByAuctionStatusType(AuctionStatusType.ACTIVE).stream().sorted(Comparator.comparing(AuctionModel::isPromoted).reversed()).collect(Collectors.toList());
    }

    public List<AuctionModel> getAuctionsByUser(UserModel user) { // 1.4 Prezentacja listy aukcji (zalogowanego) usera
        return auctionRepository.findByUserModel(user);
//        return List.of();
    }

//    public List<AuctionObservationModel> getObservedAuctionsByUser(UserModel user){
//         return auctionObservationRepository.findByUserModel(user);
// //       return List.of();
//    }

    public void addAuction(AuctionModel auction, Principal principal) {
        auction.setUserModel(userRepository.findByAccountNameEquals(principal.getName()));
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

    public void buyAuctionWithBuyNowButton(AuctionModel auction) {
        if (auction.getAuctionStatusType() == AuctionStatusType.ACTIVE) {
            auction.setAuctionStatusType(AuctionStatusType.SOLD);
            auctionRepository.save(auction);
        }
    }

    public void processAuction(AuctionModel auction, Principal principal) {
        if (auction.getMinValue() != null && auction.getMinValue().compareTo(BigDecimal.ZERO) > 0) {
            // to jest licytacja
            categoryService.setAuctionToCategory(auction);
            biddingService.addBidding(auction);
          addAuction(auction,principal);
        } else {
            // to jest zwykła aukcja
            categoryService.setAuctionToCategory(auction);
            addAuction(auction,principal);
        }
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

    public List<AuctionModel> getAllUserAuctions(Principal principal) {

        return auctionRepository.findAllByAuctionStatusType(AuctionStatusType.ACTIVE)
                .stream()
                .filter(a -> a.getUserModel().getId().equals(userRepository.findByAccountNameEquals(principal.getName()).getId()))
                .collect(Collectors.toList());

    }
}