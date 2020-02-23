package com.assel.backendassignment.product.service;

import com.assel.backendassignment.product.dto.ProductDTO;
import com.assel.backendassignment.product.entity.Product;

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
    List<Product> findAll();

    /**
     * Deletes all products
     */
    void deleteAll();

    /**
     * Persists a product
     *
     * @param product the product
     * @return the persisted product
     */
    Product saveInsert(ProductDTO product);

    /**
     * Persists a product
     *
     * @param product the product
     * @return the persisted product
     */
    Product saveUpdate(ProductDTO product);

    /**
     * Retrieves a product
     *
     * @param id a product id
     * @return the product with a given id
     */
    Optional<Product> findById(Long id);
}
