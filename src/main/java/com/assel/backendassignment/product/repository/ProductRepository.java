package com.assel.backendassignment.product.repository;

import com.assel.backendassignment.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Product repository
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * Retrieves all products
     *
     * @return a list of products
     */
    @Override
    List<Product> findAll();

    /**
     * Deletes all products
     */
    @Override
    void deleteAll();

    /**
     * Persists a product
     *
     * @param product the product
     * @return the persisted product
     */
    @Override
    Product save(Product product);

    /**
     * Retrieves a product
     *
     * @param id a product id
     * @return the product with a given id
     */
    @Override
    Optional<Product> findById(Long id);
}