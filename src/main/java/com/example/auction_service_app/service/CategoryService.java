package com.example.auction_service_app.service;

import com.example.auction_service_app.model.AuctionModel;
import com.example.auction_service_app.model.CategoryModel;
import com.example.auction_service_app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll();
    } // 1.1 Prezentacja kategorii

    public CategoryModel getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public void setAuctionToCategory(AuctionModel auctionToAdd){

        List<AuctionModel> auctionlList = getCategoryById(auctionToAdd.getCategoryModel().getId()).getAuctions();
        auctionlList.add(auctionToAdd);
    }
}