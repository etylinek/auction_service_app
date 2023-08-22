package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

        Optional<UserModel> findByAccountName(String accountName);

}
