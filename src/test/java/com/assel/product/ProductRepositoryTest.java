package com.assel.product;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findAll() {
        Product product = new Product();
        product.setId(Long.valueOf(UUID.randomUUID().toString()));
        product.setName("name");
        product.setCurrentPrice("123.456");
        product.setLastUpdate(Instant.now().toString());
        productRepository.save(product);

        Product otherProduct = new Product();
        otherProduct.setId(Long.valueOf(UUID.randomUUID().toString()));
        otherProduct.setName("other name");
        otherProduct.setCurrentPrice("234.567");
        otherProduct.setLastUpdate(Instant.now().toString());
        productRepository.save(otherProduct);

        List<Product> productList = productRepository.findAll();
        Assert.assertNotNull(productList);
        Assert.assertEquals(2, productList.size());

        Assert.assertEquals(productList.get(0).getId(), product.getId());
        Assert.assertEquals(productList.get(0).getName(), product.getName());
        Assert.assertEquals(productList.get(0).getCurrentPrice(), product.getCurrentPrice());
        Assert.assertEquals(productList.get(0).getLastUpdate(), product.getLastUpdate());

        Assert.assertEquals(productList.get(1).getId(), otherProduct.getId());
        Assert.assertEquals(productList.get(1).getName(), otherProduct.getName());
        Assert.assertEquals(productList.get(1).getCurrentPrice(), otherProduct.getCurrentPrice());
        Assert.assertEquals(productList.get(1).getLastUpdate(), otherProduct.getLastUpdate());
    }

    @Test
    void save() {
        Long id = Long.valueOf(UUID.randomUUID().toString());

        Product product = new Product();
        product.setId(id);
        product.setName("name");
        product.setCurrentPrice("123.456");
        product.setLastUpdate(Instant.now().toString());
        productRepository.save(product);

        Optional<Product> optionalOtherProduct = productRepository.findById(id);
        Assert.assertNotNull(optionalOtherProduct);
        Product otherProduct = optionalOtherProduct.get();
        Assert.assertEquals(product.getId(), otherProduct.getId());
        Assert.assertEquals(product.getName(), otherProduct.getName());
        Assert.assertEquals(product.getCurrentPrice(), otherProduct.getCurrentPrice());
        Assert.assertEquals(product.getLastUpdate(), otherProduct.getLastUpdate());
    }

    @Test
    void findById() {
        Long id = Long.valueOf(UUID.randomUUID().toString());

        Product product = new Product();
        product.setId(id);
        product.setName("name");
        product.setCurrentPrice("123.456");
        product.setLastUpdate(Instant.now().toString());
        productRepository.save(product);

        Optional<Product> optionalOtherProduct = productRepository.findById(id);
        Assert.assertNotNull(optionalOtherProduct);
        Product otherProduct = optionalOtherProduct.get();
        Assert.assertEquals(product.getId(), otherProduct.getId());
        Assert.assertEquals(product.getName(), otherProduct.getName());
        Assert.assertEquals(product.getCurrentPrice(), otherProduct.getCurrentPrice());
        Assert.assertEquals(product.getLastUpdate(), otherProduct.getLastUpdate());
    }
}