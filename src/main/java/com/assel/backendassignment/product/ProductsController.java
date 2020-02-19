package com.assel.backendassignment.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PutMapping("/api/products")
    public String putProducts() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/api/products")
    public String postProducts() {
        return "Greetings from Spring Boot!";
    }
}