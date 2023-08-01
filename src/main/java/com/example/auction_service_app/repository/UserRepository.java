package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
