package com.assel.backendassignment.product.repository;

import com.assel.backendassignment.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Product repository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

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
    Product save(Product product);

    /**
     * Retrieves a product
     *
     * @param id a product id
     * @return the product with a given id
     */
    Optional<Product> findById(Long id);
}