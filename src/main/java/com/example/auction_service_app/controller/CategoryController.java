package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.CategoryModel;
import com.example.auction_service_app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String getCategoryList(Model model){
        List<CategoryModel> categoryList = categoryService.getAllCategories();
        model.addAttribute("categories", categoryList);
        return "/categoryList"; //widok do dodania
    }
}