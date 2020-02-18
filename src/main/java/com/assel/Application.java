package com.assel;

import com.assel.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface Application extends JpaRepository<Product, Long> {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}