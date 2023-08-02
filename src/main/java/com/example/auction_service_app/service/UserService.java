package com.example.auction_service_app.service;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.AuctionObservation;
import com.example.auction_service_app.model.Bidding;
import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.repository.AuctionObservationRepository;
import com.example.auction_service_app.repository.AuctionRepository;
import com.example.auction_service_app.repository.BiddingRepository;
import com.example.auction_service_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private BiddingRepository biddingRepository;
    @Autowired
    private AuctionObservationRepository auctionObservationRepository;

/*    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }*/

/*    public List<AuctionModel> getAuctionsByUserEmail(String email) {
        UserModel user = userRepository.findByEmail(email);
        return auctionRepository.findByUser(user);
    }*/

/*    public List<Bidding> getBiddingsByUserEmail(String email) {
        UserModel user = userRepository.findByEmail(email);
        return biddingRepository.findByUser(user);
    }*/

/*    public List<AuctionObservation> getObservedAuctionsByUserEmail(String email) {
        UserModel user = userRepository.findByEmail(email);
        return auctionObservationRepository.findByUser(user);
    }*/
}