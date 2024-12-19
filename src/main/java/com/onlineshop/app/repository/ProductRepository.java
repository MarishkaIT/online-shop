package com.onlineshop.app.repository;

import com.onlineshop.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
