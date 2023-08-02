package com.example.auction_service_app.controller;

import com.example.auction_service_app.model.CategoryModel;
import com.example.auction_service_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CategoryService categoryService;

    @Autowired
    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<CategoryModel> categories = categoryService.getAllCategories(); //1.1 Prezentacja kategorii, które prowadzą do aukcji z tych kategorii (plik 'home.html' w resources/templates)
        model.addAttribute("categories", categories);            //metoda bazowa w 'CategoryService'
        return "home"; // zwraca nazwę widoku strony głównej
    }

    // Inne ogólne metody, jeśli są potrzebne
}