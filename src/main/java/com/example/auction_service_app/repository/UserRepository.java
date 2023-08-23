package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByAccountNameEquals(String name);

        Optional<UserModel> findByAccountName(String accountName);


}
