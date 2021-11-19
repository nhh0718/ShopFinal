package com.example.demooooo.shop.service;


import com.example.demooooo.shop.mapper.ShopMapper;
import com.example.demooooo.shop.repository.ShopRepository;
import com.example.demooooo.shop.shopDto.ShopDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService{

    @Autowired private ShopRepository shopRepository;

    @Autowired private ShopMapper shopMapper;

    @Override
    public List<ShopDto> getAllShop() {
        return shopMapper.modelsToDtos(shopRepository.findAll());
    }

    @Override
    public void saveShop(ShopDto shop) {
        shopRepository.save(shopMapper.DtoToModel(shop));
    }

    @Override
    public void deleteShop(Integer id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Optional<ShopDto> findShopById(Integer id) {
        return Optional.of(shopMapper.modelToDto(shopRepository.findById(id).get()));
    }

    @Override
    public Optional<ShopDto> findShopByUserid(Integer id) {
        return Optional.ofNullable(shopMapper.modelToDto(shopRepository.findShopByUserid(id)));
    }

    @Override
    public Optional<ShopDto> findShopByShopname(String shopname){
            return Optional.ofNullable(shopMapper.modelToDto(shopRepository.findShopByShopname(shopname)));
    }
}
