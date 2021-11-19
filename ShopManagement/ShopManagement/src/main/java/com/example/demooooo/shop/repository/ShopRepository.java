package com.example.demooooo.shop.repository;


import com.example.demooooo.shop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShopRepository extends JpaRepository<Shop, Integer> {
    Shop findShopByUserid(Integer userid);
    Shop findShopByShopname(String shopname);
}
