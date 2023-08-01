package com.example.auction_service_app.repository;

import com.example.auction_service_app.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {


}
