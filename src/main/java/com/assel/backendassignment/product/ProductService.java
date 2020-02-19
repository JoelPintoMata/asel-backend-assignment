package com.assel.backendassignment.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();

    Product save(Product product);

    Optional<Product> getProduct(Long id);
}
