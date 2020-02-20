package com.assel.backendassignment.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Product save(ProductDTO productDTO) {
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
