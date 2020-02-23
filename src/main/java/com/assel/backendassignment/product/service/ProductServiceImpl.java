package com.assel.backendassignment.product.service;

import com.assel.backendassignment.product.dto.ProductDTO;
import com.assel.backendassignment.product.entity.Product;
import com.assel.backendassignment.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Product service implementation
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public Product saveUpdate(ProductDTO productDTO) {
        if (!this.findById(productDTO.getId()).isPresent()) {
            throw new EntityNotFoundException("A product with this id does not exist");
        }
        return productRepository.save(this.productDTOtoEntity(productDTO));
    }

    @Override
    public Product saveInsert(ProductDTO productDTO) {
        if (this.findById(productDTO.getId()).isPresent()) {
            throw new EntityExistsException("A product with this id already exists");
        }
        return productRepository.save(this.productDTOtoEntity(productDTO));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Converts a product dto to an entity
     *
     * @param productDTO a product dto
     * @return a product entity
     */
    private Product productDTOtoEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCurrentPrice(productDTO.getCurrentPrice());
        product.setLastUpdate(productDTO.getLastUpdate());
        return product;
    }
}
