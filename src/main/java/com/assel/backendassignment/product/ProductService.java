package com.assel.backendassignment.product;

import java.util.List;
import java.util.Optional;

/**
 * Product service
 */
public interface ProductService {

    /**
     * Retrieves all products
     *
     * @return a list of products
     */
    List<Product> getProducts();

    /**
     * Persists a product
     *
     * @param product the product
     * @return the persisted product
     */
    Product save(Product product);

    /**
     * Retrieves a product
     *
     * @param id a product id
     * @return the product with a given id
     */
    Optional<Product> getProduct(Long id);
}
