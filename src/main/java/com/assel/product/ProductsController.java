package com.assel.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductsController {

    @GetMapping("/api/products")
    public String getProducts() {
        return "Greetings from Spring Boot!";
    }

    @PutMapping("/api/products")
    public String PutProducts() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/api/products")
    public String PostProducts() {
        return "Greetings from Spring Boot!";
    }

}