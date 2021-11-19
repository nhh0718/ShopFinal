package com.example.demooooo.customer.service;

import com.example.demooooo.customer.dto.CusProductDto;
import com.example.demooooo.customer.mapper.CusProductMapper;
import com.example.demooooo.customer.repository.CusProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CusProductService {
    @Autowired private CusProductRepository productRepository;

    @Autowired private CusProductMapper productMapper;

    public List<CusProductDto> getAllProduct() {
        return productMapper.modelstoDtos(productRepository.findAll());
    }

    public void saveProduct(CusProductDto cusProductDto) {
        productRepository.save(productMapper.dtoToModel(cusProductDto));
    }

    public void saveAllProduct(List<CusProductDto> cusProductDtoList) {
        productRepository.saveAll(productMapper.dtostoModels(cusProductDtoList));
    }

    public List<CusProductDto> getProductByName() {
        return productMapper.modelstoDtos(productRepository.findAll(Sort.by(Sort.Direction.ASC,"productname")));
    }
    public Optional<CusProductDto> findProductById(Integer id) {
        try{
            return Optional.of(productMapper.modelToDto(productRepository.findProductById(id).get()));
        } catch (Exception ex){
            return Optional.ofNullable(null);
        }
    }
    public List<CusProductDto> findProductByIdshop(Integer id){
        return productMapper.modelstoDtos(productRepository.findProductByIdshop(id));
    }
    public List<CusProductDto> sortProduct(Integer idshop){
        return productMapper.modelstoDtos(productRepository.findProductByIdshopOrderByProductnameAsc(idshop));
    }
}
