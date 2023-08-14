package com.example.auction_service_app.service;

import com.example.auction_service_app.dto.BidRequest;
import com.example.auction_service_app.exception.BidTooLowException;
import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.BiddingModel;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.repository.AuctionRepository;
import com.example.auction_service_app.repository.BiddingRepository;
import com.example.auction_service_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BiddingService {

    private final BiddingRepository biddingRepository;

    private final AuctionRepository auctionRepository;

    private final UserRepository userRepository;  // zakładając, że posiadasz odpowiednie repozytorium użytkowników

    public List<BiddingModel> getBiddingsByUser(UserModel user){
        return biddingRepository.findByUserModel(user);
    }


    public void addBidding(AuctionModel auction){
        auctionRepository.save(auction);
    }

    public boolean placeBid(Long auctionId, BigDecimal proposedValue, Long userId) {
        Optional<AuctionModel> auctionOpt = auctionRepository.findById(auctionId);
        Optional<UserModel> userOpt = userRepository.findById(userId);

        if (!auctionOpt.isPresent() || !userOpt.isPresent()) {
            // aukcja lub użytkownik nie istnieją
            return false;
        }

        AuctionModel auction = auctionOpt.get();
        UserModel user = userOpt.get();

        // sprawdzenie, czy zaproponowana kwota jest wyższa niż aktualna minimalna wartość
        if (proposedValue.compareTo(auction.getMinValue()) <= 0) {
            return false;  // oferta jest zbyt niska
        }

        // aktualizacja ceny minimalnej w aukcji
        auction.setMinValue(proposedValue);
       // auctionRepository.save(auction);

        // dodanie nowego rekordu w historii licytacji
        BiddingModel newBid = new BiddingModel();
        newBid.setAuction(auction);
        newBid.setUserModel(user);
        newBid.setValue(proposedValue);
        newBid.setBidTime(LocalDateTime.now());  // zakładam, że używasz `java.time.LocalDateTime`
        biddingRepository.save(newBid);

        return true;  // licytacja została pomyślnie złożona
    }






/*
    @Transactional
    public void placeBid(Long biddingId, BidRequest bidRequest) throws BidTooLowException {
        BiddingModel bidding = biddingRepository.findById(biddingId).orElseThrow(() -> new EntityNotFoundException("Nie znaleziono aukcji"));

        BigDecimal highestBid = biddingRepository.findHighestBidForAuction(biddingId);
        if (bidRequest.getBidAmount().compareTo(highestBid) <= 0) {
            throw new BidTooLowException("zbyt mala kwota");
        }

        BiddingModel biddingModel = new BiddingModel();
        biddingModel.setAuction(auction);
        biddingModel.setUser(bidRequest.getUser());
        biddingModel.setValue(bidRequest.getBidAmount());
        biddingRepository.save(biddingModel);
    }*/

    /*@Transactional
    public void buyNow(Long auctionId) {
        AuctionModel auction = auctionRepository.findById(auctionId).orElseThrow(() -> new EntityNotFoundException("Nie znaleziono aukcji"));
        // Ustaw status aukcji na 'zamkniety', ustaw zwyciezkiego uzytkownika itp.
        auctionRepository.save(auction);
    }*/
}
