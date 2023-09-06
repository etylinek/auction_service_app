package com.example.auction_service_app.service;


import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.BiddingModel;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.repository.AuctionRepository;
import com.example.auction_service_app.repository.BiddingRepository;
import com.example.auction_service_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BiddingService {

    private final BiddingRepository biddingRepository;

    private final AuctionRepository auctionRepository;

    private final UserRepository userRepository;  // zakładając, że posiadasz odpowiednie repozytorium użytkowników

    public List<BiddingModel> getBiddingsByUser(UserModel user) {
        return biddingRepository.findByUserModel(user);
    }


    public void addBidding(AuctionModel auction) {
        auctionRepository.save(auction);
    }

    public List<BiddingModel> getAuctionBiddings(Long id){
        return biddingRepository.findAllByAuction_Id(id);
    }

    public boolean placeNewBid(Long auctionId, Long proposedValue, Long userId) {
        AuctionModel auction = auctionRepository.findById(auctionId).orElse(null);
        UserModel user = userRepository.findById(userId).orElse(null);

        if (auction == null || user == null || proposedValue == null) {
            // aukcja lub użytkownik nie istnieją
            return false;
        }

        BigDecimal bigDecimal = BigDecimal.valueOf(proposedValue);
        // sprawdzenie, czy zaproponowana kwota jest wyższa niż aktualna minimalna wartość
        if (bigDecimal.compareTo(auction.getMinValue()) <= 0) {
            return false;  // oferta jest zbyt niska
        }

        // aktualizacja ceny minimalnej w aukcji
        auction.setMinValue(bigDecimal);
        // auctionRepository.save(auction);

        // dodanie nowego rekordu w historii licytacji
        BiddingModel newBid = new BiddingModel();
        newBid.setAuction(auction);
        newBid.setUserModel(user);
        newBid.setValue(bigDecimal);
        newBid.setBidTime(LocalDateTime.now());  // zakładam, że używasz `java.time.LocalDateTime`
        biddingRepository.save(newBid);

        return true;  // licytacja została pomyślnie złożona
    }


    public RedirectView placeBid(Long auctionId, Long proposedValue, Principal principal) {

        Long userId = userRepository.findByAccountName(principal.getName()).orElse(null).getId();

        if (placeNewBid(auctionId, proposedValue, userId)) {
            return new RedirectView("/auctions/auctionDetails/"+auctionId);
        }
        return new RedirectView("../tooLow");
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
