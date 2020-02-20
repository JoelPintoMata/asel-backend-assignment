package com.assel.backendassignment.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        return productService.getProducts();
    }

    @GetMapping("/api/product/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable Long id) {
        Optional<Product> product;
        try {
            product = productService.getProduct(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Error while get the product: %s", e.getMessage()));
        }
        if (!product.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product not found"));
        }
        return product.get();
    }

    @PutMapping("/api/products/{id}")
    public Product putProducts(@PathVariable Long id,
                               @RequestBody ProductDTO productDTO) {
        Product product;
        try {
            productDTO.setId(id);
            product = productService.save(productDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Error while saving the product: %s", e.getMessage()));
        }
        return product;
    }

    @PostMapping("/api/products")
    public Product postProducts(@RequestBody ProductDTO productDTO) {
        Product product;
        try {
            product = productService.save(productDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Error while saving the product: %s", e.getMessage()));
        }
        return product;
    }
}