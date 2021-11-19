package com.example.demooooo.customer.mapper;

import com.example.demooooo.customer.dto.CusProductDto;
import com.example.demooooo.customer.model.CusProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CusProductMapper {
    CusProductMapper INSTANCE = Mappers.getMapper(CusProductMapper.class);

    CusProductDto modelToDto(CusProduct cusProduct);

    CusProduct dtoToModel(CusProductDto cusProductDto);

    List<CusProductDto> modelstoDtos(List<CusProduct> cusProducts);

    List<CusProduct> dtostoModels(List<CusProductDto> cusProductDtos);
}
