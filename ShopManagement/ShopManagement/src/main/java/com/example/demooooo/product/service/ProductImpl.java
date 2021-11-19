package com.example.demooooo.product.service;

import com.example.demooooo.product.dto.ProductDTO;
import com.example.demooooo.product.mapper.ProductMapper;
import com.example.demooooo.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<ProductDTO> getAllProduct() {
        return productMapper.modelsToDTOs(productRepository.findAll());
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.DTOtoModel(productDTO));
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> findProductByShopId(Integer id) {
        return productMapper.modelsToDTOs(productRepository.findProductByIdshop(id));
    }

    @Override
    public Optional<ProductDTO> findProductById(Integer id) {
        return Optional.of(productMapper.modeltoDTO(productRepository.findById(id).get()));
    }
}
