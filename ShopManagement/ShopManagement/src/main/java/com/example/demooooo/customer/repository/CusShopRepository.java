package com.example.demooooo.customer.repository;

import com.example.demooooo.customer.model.CusShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CusShopRepository extends JpaRepository<CusShop, Integer> {

    CusShop findShopByShopname(String shopname);

    @Query(value = "select * from shop where totalselledproduct >= 100 order by totalselledproduct DESC limit 10", nativeQuery = true)
    List<CusShop> findAllBySelled();
}
