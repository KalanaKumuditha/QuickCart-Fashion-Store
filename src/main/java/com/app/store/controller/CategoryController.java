package com.app.store.controller;

import com.app.store.entity.Category;
import com.app.store.entity.Product;
import com.app.store.repository.CategoryRepository;
import com.app.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController { // category controller class

    private final CategoryRepository categoryRepository; // to access category data in to database
    private final ProductService productService; //product service is used to retrieve filtered product data from backend

    @GetMapping("/categories")
    public String viewCategoryGallery(Model model) { //Get all categories
        List<Category> allCategories = categoryRepository.findAll();
        model.addAttribute("categories", allCategories);
        return "category/list"; // filter dropdown
    }

    @GetMapping("/category/{name}")
    public String viewProductsInCategory(@PathVariable String name, Model model) { //handle category based filtering
        List<Product> products = productService.getProductsWithFilterAndSort(null, name, null); //calling filter service
        model.addAttribute("products", products);// send filtered product to the ui
        model.addAttribute("currentCategory", name); // current category display
        model.addAttribute("categoryFeatureTitle", name + " Collection"); //dynamically update the collection title based on selected category
        return "shop"; // filtered product are display in shop page
    }
}
