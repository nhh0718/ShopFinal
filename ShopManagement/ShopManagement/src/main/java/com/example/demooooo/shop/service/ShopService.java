package com.example.demooooo.shop.service;

import com.example.demooooo.shop.shopDto.ShopDto;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    List<ShopDto> getAllShop();
    void saveShop(ShopDto shop);
    void deleteShop(Integer id);
    Optional<ShopDto> findShopById(Integer id);
    Optional<ShopDto> findShopByUserid(Integer id);
    Optional<ShopDto> findShopByShopname(String shopname);
}
