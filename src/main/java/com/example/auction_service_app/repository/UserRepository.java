package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
