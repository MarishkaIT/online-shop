package com.onlineshop.app.service;

import com.onlineshop.app.exception.ResourceNotFoundException;
import com.onlineshop.app.model.Product;
import com.onlineshop.app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(Product product) {
        Product oldProduct = productRepository.findById(product.getId()).orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setImage(product.getImage());
        oldProduct.setCategory(product.getCategory());
        return productRepository.save(oldProduct);

    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
        productRepository.delete(product);
    }
}
