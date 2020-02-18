package com.assel.product;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findAll() {
        productRepository.findAll();
    }

    @Test
    void save() {
        Product product = new Product();
        productRepository.save(product);
    }

    @Test
    void findById() {
        Long id = Long.valueOf(UUID.randomUUID().toString());
        Product product = new Product();
        Assert.assertEquals(product, productRepository.findById(id));
    }
}