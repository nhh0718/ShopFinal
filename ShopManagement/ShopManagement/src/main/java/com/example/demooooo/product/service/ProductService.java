package com.example.demooooo.product.service;

import com.example.demooooo.product.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProduct();

    void saveProduct(ProductDTO productDTO);

    void deleteProduct(Integer id);

    List<ProductDTO> findProductByShopId(Integer id);

    Optional<ProductDTO> findProductById(Integer id);

    Optional<ProductDTO> findProductByProductname(String productname);
}
