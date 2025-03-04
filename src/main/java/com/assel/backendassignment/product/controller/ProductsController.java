package com.assel.backendassignment.product.controller;

import com.assel.backendassignment.product.dto.ProductDTO;
import com.assel.backendassignment.product.entity.Product;
import com.assel.backendassignment.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    @ResponseBody
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/api/product/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable Long id) {
        Optional<Product> product;
        try {
            product = productService.findById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Error while get the product: %s", e.getMessage()));
        }
        if (!product.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product not found"));
        }
        return product.get();
    }

    @PutMapping("/api/products/{id}")
    @ResponseBody
    public ResponseEntity<Product> putProduct(@PathVariable Long id,
                                              @RequestBody ProductDTO productDTO) {
        Product product;
        try {
            productDTO.setId(id);
            product = productService.saveUpdate(productDTO);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Error while saving the product: %s", e.getMessage()));
        }
        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }

    @PostMapping("/api/products")
    @ResponseBody
    public ResponseEntity<Product> postProduct(@RequestBody ProductDTO productDTO) {
        Product product;
        try {
            product = productService.saveInsert(productDTO);
        } catch (EntityExistsException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Error while saving the product: %s", e.getMessage()));
        }
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}