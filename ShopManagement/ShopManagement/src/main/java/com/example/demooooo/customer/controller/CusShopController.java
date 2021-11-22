package com.example.demooooo.customer.controller;

import com.example.demooooo.customer.dto.CusShopDto;
import com.example.demooooo.customer.service.CusProductService;
import com.example.demooooo.customer.service.CusShopService;
import com.example.demooooo.dto.UserDto;
import com.example.demooooo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CusShopController {
    @Autowired
    private CusShopService cusShopService;
    @Autowired
    private UserService userService;

    @GetMapping("/cus")
    public String viewlist(Model model) {
        List<CusShopDto> shop = cusShopService.getShopByNameASC();
        List<CusShopDto> shopl = cusShopService.findAllBySelled();
        model.addAttribute("cusShop", shop);
        model.addAttribute("cusShops", shopl);
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword, @RequestParam Integer userid) {
        Optional<CusShopDto> shop = cusShopService.findShopByName(keyword);
        shop.ifPresent(o -> model.addAttribute("cusShop", o));
        UserDto userDto = userService.getUserById(userid).get();
        model.addAttribute("user", userDto);
        return "guest";
    }
}
