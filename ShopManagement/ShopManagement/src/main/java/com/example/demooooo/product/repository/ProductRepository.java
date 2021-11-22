package com.example.demooooo.product.repository;

import com.example.demooooo.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByIdshop(Integer idshop);
    Product findProductByProductname(String productname);
}
