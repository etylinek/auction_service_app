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

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void editUser(UserModel editUser) {
        userRepository.save(editUser);
    }

        public UserModel findByAccountName(String accountName) {
            return userRepository.findByAccountName(accountName).orElse(null);
                 //   .orElseThrow(() -> new UsernameNotFoundException("Użytkownik o podanej nazwie konta nie został znaleziony: " + accountName));
        }




//    @Autowired
//    private AuctionRepository auctionRepository;
//    @Autowired
//    private BiddingRepository biddingRepository;
//    @Autowired
//    private AuctionObservationRepository auctionObservationRepository;



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