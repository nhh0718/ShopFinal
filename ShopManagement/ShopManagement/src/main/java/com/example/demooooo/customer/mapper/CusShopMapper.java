package com.example.demooooo.customer.mapper;

import com.example.demooooo.customer.dto.CusShopDto;
import com.example.demooooo.customer.model.CusShop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CusShopMapper {
    CusShopMapper INSTANCE = Mappers.getMapper(CusShopMapper.class);

    CusShopDto modelToDto(CusShop cusShop);

    CusShop dtoToModel(CusShopDto cusShopDto);

    List<CusShopDto> modelstoDtos(List<CusShop> cusShops);

}
