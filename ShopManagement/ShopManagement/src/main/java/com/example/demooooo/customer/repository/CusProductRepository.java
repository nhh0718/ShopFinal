package com.example.demooooo.customer.repository;

import com.example.demooooo.customer.model.CusProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CusProductRepository extends JpaRepository<CusProduct, Integer> {
    Optional<CusProduct> findProductByProductname(String productname);
    Optional<CusProduct> findProductById(Integer id);
    List<CusProduct> findProductByIdshop(Integer id);
    List<CusProduct> findProductByIdshopOrderByProductnameAsc(Integer idshop);
}
