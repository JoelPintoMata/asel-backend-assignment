package com.assel.backendassignment.product.service;

import com.assel.backendassignment.product.dto.ProductDTO;
import com.assel.backendassignment.product.entity.Product;
import com.assel.backendassignment.product.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProductServiceImplTest {

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void givenExistingProduct_whenUpdate_thenUpdate() {
        Product product = new Product();
        product.setId(1L);

        ProductService productService = new ProductServiceImpl(productRepository);
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        Assert.assertNotNull(productService.saveUpdate(productDTO));
    }

    @Test
    public void givenNonExistingProduct_whenUpdate_thenThrowException() {
        ProductService productService = new ProductServiceImpl(productRepository);
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);

        boolean flag = false;
        try {
            productService.saveUpdate(productDTO);
        } catch (EntityNotFoundException e) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void givenNonExistingProduct_whenSave_thenSave() {
        Product product = new Product();
        product.setId(1L);

        ProductService productService = new ProductServiceImpl(productRepository);
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        Assert.assertNotNull(productService.saveInsert(productDTO));
    }

    @Test
    public void givenExistingProduct_whenSave_thenException() {
        Product product = new Product();
        product.setId(1L);

        ProductService productService = new ProductServiceImpl(productRepository);
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);

        boolean flag = false;
        try {
            productService.saveInsert(productDTO);
        } catch (EntityExistsException e) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }
}