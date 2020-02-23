package com.assel.backendassignment.product.repository;

import com.assel.backendassignment.product.entity.Product;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void beforeEach() {
        productRepository.deleteAll();
    }

    @Test
    public void findAllTest() {
        Product product = new Product();
        product.setName("name");
        product.setCurrentPrice("123.456");
        product.setLastUpdate(Instant.now().toString());
        product = productRepository.save(product);

        Product otherProduct = new Product();
        otherProduct.setName("other name");
        otherProduct.setCurrentPrice("234.567");
        otherProduct.setLastUpdate(Instant.now().toString());
        otherProduct = productRepository.save(otherProduct);

        List<Product> productList = productRepository.findAll();
        Assert.assertNotNull(productList);
        Assert.assertEquals(2, productList.size());

        Assert.assertEquals(productList.get(0).getName(), product.getName());
        Assert.assertEquals(productList.get(0).getCurrentPrice(), product.getCurrentPrice());
        Assert.assertEquals(productList.get(0).getLastUpdate(), product.getLastUpdate());

        Assert.assertEquals(productList.get(1).getName(), otherProduct.getName());
        Assert.assertEquals(productList.get(1).getCurrentPrice(), otherProduct.getCurrentPrice());
        Assert.assertEquals(productList.get(1).getLastUpdate(), otherProduct.getLastUpdate());
    }

    @Test
    public void givenNewProduct_whenInsert_thenPersist() {
        Product product = new Product();
        product.setName("name");
        product.setCurrentPrice("123.456");
        product.setLastUpdate(Instant.now().toString());
        product = productRepository.save(product);

        Optional<Product> optionalOtherProduct = productRepository.findById(product.getId());
        Assert.assertNotNull(optionalOtherProduct);
        Product otherProduct = optionalOtherProduct.get();
        Assert.assertEquals(product.getId(), otherProduct.getId());
        Assert.assertEquals(product.getName(), otherProduct.getName());
        Assert.assertEquals(product.getCurrentPrice(), otherProduct.getCurrentPrice());
        Assert.assertEquals(product.getLastUpdate(), otherProduct.getLastUpdate());
    }

    @Test
    public void givenExistingProduct_whenUpdate_thenUpdate() {
        Product product = new Product();
        product.setName("name");
        product.setCurrentPrice("123.456");
        product.setLastUpdate(Instant.now().toString());
        product = productRepository.save(product);

        List<Product> productList = productRepository.findAll();
        Assert.assertNotNull(productList);
        Assert.assertEquals(1, productList.size());

        Optional<Product> optionalOtherProduct = productRepository.findById(product.getId());

        Product otherProduct = optionalOtherProduct.get();
        otherProduct.setName("updated name");
        otherProduct = productRepository.save(otherProduct);

        Assert.assertEquals(product.getId(), otherProduct.getId());
        Assert.assertEquals(product.getName(), "updated name");
        Assert.assertEquals(product.getCurrentPrice(), otherProduct.getCurrentPrice());
        Assert.assertEquals(product.getLastUpdate(), otherProduct.getLastUpdate());
    }

    @Test
    public void findByIdTest() {
        Product product = new Product();
        product.setName("name");
        product.setCurrentPrice("123.456");
        product.setLastUpdate(Instant.now().toString());
        product = productRepository.save(product);

        Optional<Product> optionalOtherProduct = productRepository.findById(product.getId());
        Assert.assertNotNull(optionalOtherProduct);
        Product otherProduct = optionalOtherProduct.get();
        Assert.assertEquals(product.getId(), otherProduct.getId());
        Assert.assertEquals(product.getName(), otherProduct.getName());
        Assert.assertEquals(product.getCurrentPrice(), otherProduct.getCurrentPrice());
        Assert.assertEquals(product.getLastUpdate(), otherProduct.getLastUpdate());
    }
}