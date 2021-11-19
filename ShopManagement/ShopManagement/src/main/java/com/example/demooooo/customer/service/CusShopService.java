package com.example.demooooo.customer.service;

import com.example.demooooo.customer.dto.CusShopDto;
import com.example.demooooo.customer.mapper.CusShopMapper;
import com.example.demooooo.customer.repository.CusShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CusShopService {
    @Autowired
    private CusShopRepository shopRepository;
    @Autowired
    private CusShopMapper shopMapper;


    public List<CusShopDto> getAllShop() {
        return shopMapper.modelstoDtos(shopRepository.findAll());
    }

    public void saveShop(CusShopDto cusShopDto) {
        shopRepository.save(shopMapper.dtoToModel(cusShopDto));
    }


    public Optional<CusShopDto> getShopById(Integer id) {
        return Optional.of(shopMapper.modelToDto(shopRepository.findById(id).get()));
    }

    // Truy cập vào trang sản phẩm của từng shop thông qua nút Detail
    public Optional<CusShopDto> findShopById(Integer id) {
        return Optional.of(shopMapper.modelToDto(shopRepository.findById(id).get()));
    }


    // Sắp xếp tên shop theo thứ tự ABC
    public List<CusShopDto> getShopByNameASC() {
        return shopMapper.modelstoDtos(shopRepository.findAll(Sort.by(Sort.Direction.ASC, "shopname")));
    }

    // Tìm kiếm shop theo tên
    public Optional<CusShopDto> findShopByName(String shopname) {
            return Optional.of(shopMapper.modelToDto(shopRepository.findShopByShopname(shopname).get()));
    }

    public List<CusShopDto> findAllBySelled() {
        return shopMapper.modelstoDtos(shopRepository.findAllBySelled());
    }

//    public List<ShopDto> findShopBySelledquantity() {
//        return shopMapper.modelstoDtos(shopRepository.findShopBySelledquantity());
//    }
}

