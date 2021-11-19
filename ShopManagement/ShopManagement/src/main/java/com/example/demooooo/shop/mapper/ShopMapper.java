package com.example.demooooo.shop.mapper;

import com.example.demooooo.shop.model.Shop;
import com.example.demooooo.shop.shopDto.ShopDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);

    ShopDto modelToDto(Shop shop);

    Shop DtoToModel(ShopDto shopDto);

    List<ShopDto> modelsToDtos(List<Shop> shop);
}
