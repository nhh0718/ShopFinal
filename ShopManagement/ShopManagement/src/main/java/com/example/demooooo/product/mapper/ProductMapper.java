package com.example.demooooo.product.mapper;

import com.example.demooooo.product.dto.ProductDTO;
import com.example.demooooo.product.model.Product;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO modeltoDTO(Product product);

    Product DTOtoModel(ProductDTO productDTO);

    List<ProductDTO> modelsToDTOs(List<Product> product);
}
