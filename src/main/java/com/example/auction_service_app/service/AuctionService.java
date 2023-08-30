package com.example.auction_service_app.service;

import com.example.auction_service_app.model.*;
import com.example.auction_service_app.repository.*;
import com.example.auction_service_app.types.AuctionStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.math.BigDecimal;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final UserRepository userRepository;

    private final AuctionRepository auctionRepository;

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

    public List<AuctionModel> getAllActiveAuctionsToSort() {
        return auctionRepository.findAllByAuctionStatusType(AuctionStatusType.ACTIVE);
    }


    public void addAuction(AuctionModel auction, Principal principal) {
        auction.setUserModel(userRepository.findByAccountNameEquals(principal.getName()));
        auctionRepository.save(auction);
    }
    public void addAuction(AuctionModel auction) {
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

    public void buyAuctionWithBuyNowButton(Long id, Principal principal) {
        AuctionModel auction = getAuctionById(id);
        if (auction.getAuctionStatusType() == AuctionStatusType.ACTIVE) {
            auction.setAuctionStatusType(AuctionStatusType.ENDED);
            auction.setBuyer(userRepository.findByAccountNameEquals(principal.getName()));
            auctionRepository.save(auction);
        }
    }

    public void processAuction(AuctionModel auction, Principal principal) {
        if (auction.getMinValue() != null && auction.getMinValue().compareTo(BigDecimal.ZERO) > 0) {
            // to jest licytacja
            categoryService.setAuctionToCategory(auction);
            biddingService.addBidding(auction);
            addAuction(auction, principal);
        } else {
            // to jest zwykła aukcja
            categoryService.setAuctionToCategory(auction);
            addAuction(auction, principal);
        }
    }

    public List<AuctionModel> getAllUserAuctions(Principal principal) {

        return auctionRepository.findAllByAuctionStatusType(AuctionStatusType.ACTIVE)
                .stream()
                .filter(a -> a.getUserModel().getId().equals(userRepository.findByAccountNameEquals(principal.getName()).getId()))
                .collect(Collectors.toList());

    }

    public List<AuctionModel> getFilteredAuctions(String city, String voievodeship, Long sortDateType, Long buyNow, Long sortByValue) {

        List<AuctionModel> auctionList = getAllActiveAuctionsToSort();


        if (!city.equals("")) {
            auctionList = getAuctionsByCity(city, auctionList);
        }

        if (!voievodeship.equals("")) {
            auctionList = getAuctionsByVoievodeship(voievodeship, auctionList);
        }

        if (buyNow != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(buyNow);
            auctionList = getAuctionsByBuyNowValue(bigDecimal, auctionList);
        }
        if (sortDateType != null) {
            if (sortDateType == 1) {
                auctionList = sortAllActiveAuctionsWithAddDate(auctionList);
            }
            if (sortDateType == 2) {
                auctionList = sortAllActiveAuctionsWithEndDate(auctionList);
            }
        }
        if (sortByValue != null) {
            if (sortByValue == 1) {
                auctionList = sortAllActiveAuctionsWithBuyNowValueDesc(auctionList);
            }
            if (sortByValue == 2) {
                auctionList = sortAllActiveAuctionsWithBuyNowValueAsc(auctionList);
            }
        }

        return auctionList;
    }

    public List<AuctionModel> getAuctionsByCity(String city, List<AuctionModel> auctionsList) {
        return auctionsList.stream()
                .filter(auction -> auction.getUserModel().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<AuctionModel> getAuctionsByVoievodeship(String voievodeship, List<AuctionModel> auctionsList) {
        return auctionsList.stream()
                .filter(auction -> auction.getUserModel().getVoievodeship().equalsIgnoreCase(voievodeship))
                .collect(Collectors.toList());
    }

    public List<AuctionModel> getAuctionsByBuyNowValue(BigDecimal buyNowValue, List<AuctionModel> auctionsList) {
        return auctionsList.stream()
                .filter(auction -> auction.getBuyNowValue().compareTo(buyNowValue) >= 0)
                .collect(Collectors.toList());
    }

    public List<AuctionModel> sortAllActiveAuctionsWithAddDate(List<AuctionModel> auctionsList) {
        return auctionsList.stream()
                .sorted(Comparator.comparing(AuctionModel::getStartDate).reversed())
                .collect(Collectors.toList());
    }

    public List<AuctionModel> sortAllActiveAuctionsWithEndDate(List<AuctionModel> auctionsList) {
        return auctionsList.stream()
                .sorted(Comparator.comparing(AuctionModel::getEndDate).reversed())
                .collect(Collectors.toList());
    }

    public List<AuctionModel> sortAllActiveAuctionsWithBuyNowValueDesc(List<AuctionModel> auctionsList) {
        return auctionsList.stream()
                .sorted(Comparator.comparing(AuctionModel::getBuyNowValue).reversed())
                .collect(Collectors.toList());
    }

    public List<AuctionModel> sortAllActiveAuctionsWithBuyNowValueAsc(List<AuctionModel> auctionsList) {
        return auctionsList.stream()
                .sorted(Comparator.comparing(AuctionModel::getBuyNowValue))
                .collect(Collectors.toList());
    }
}