package com.example.auction_service_app.service;

import com.example.auction_service_app.model.UserModel;
import com.example.auction_service_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(UserModel user){
        userRepository.save(user);
    }













//    @Autowired
//    private AuctionRepository auctionRepository;
//    @Autowired
//    private BiddingRepository biddingRepository;
//    @Autowired
//    private AuctionObservationRepository auctionObservationRepository;

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