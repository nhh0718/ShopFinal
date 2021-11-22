package com.example.demooooo.shop.controller;

import com.example.demooooo.product.service.ProductService;
import com.example.demooooo.shop.model.Shop;
import com.example.demooooo.shop.service.ShopService;
import com.example.demooooo.shop.shopDto.ShopDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ShopController {
  @Autowired private ShopService shopService;

  @Autowired private ProductService productService;

  @GetMapping("shop")
  public String index(@RequestParam("id") Integer id, Model model, RedirectAttributes ra) {
    Optional<ShopDto> check = shopService.findShopByUserid(id);
    if (check.isPresent()) {
      model.addAttribute("shop", check.get());
      return "shop";
    } else {
      ra.addAttribute("userid", id);
      return "redirect:/shop/new";
    }
  }

  @RequestMapping("shop/new")
  public String addUser(@Valid @RequestParam("userid") Integer userid, Model model) {
    model.addAttribute("shop", new Shop());
    if (model.asMap().containsKey("shoperror"))
    {
      model.addAttribute("org.springframework.validation.BindingResult.shop",
              model.asMap().get("shoperror"));
    }
    model.addAttribute("userid", userid);
    return "createShop";
  }
  @PostMapping(value = "shop/save")
  public String saveUser(@Valid @ModelAttribute("shop") ShopDto shop, BindingResult bindingResult, RedirectAttributes ra) {
    if (bindingResult.hasErrors()) {
      ra.addFlashAttribute("shoperror", bindingResult);
      ra.addFlashAttribute("shop",shop);
      ra.addAttribute("userid", shop.getUserid());
      return "redirect:/shop/new";
    }
//
    Optional<ShopDto> checkname = shopService.findShopByShopname(shop.getShopname());
    if (checkname.isPresent()) {
      ra.addFlashAttribute("errorMessage", "Tên cửa hàng đã tồn tại");
      ra.addAttribute("userid", shop.getUserid());
      return "redirect:/shop/new";
    }
    else {
      shopService.saveShop(shop);
      ra.addFlashAttribute("message", "Lưu cửa hàng thành công. ");
      ra.addAttribute("id", shop.getUserid());
      return "redirect:/shop";
    }
  }

  @RequestMapping(value = "/shop/edit", method = RequestMethod.GET)
  public String editUser(@RequestParam("id") Integer shopId, Model model) {
    Optional<ShopDto> shopEdit = shopService.findShopById(shopId);
    model.addAttribute("userid", shopEdit.get().getUserid());
    shopEdit.ifPresent(shop -> model.addAttribute("shop", shop));
    if (model.asMap().containsKey("shoperror"))
    {
      model.addAttribute("org.springframework.validation.BindingResult.shop",
              model.asMap().get("shoperror"));
    }
    model.addAttribute("id", shopId);
    return "editShop"  ;
  }
  @PostMapping(value = "shop/update")
  public String update(@Valid @ModelAttribute("shop") ShopDto shop, BindingResult bindingResult, @RequestParam("id") Integer id, RedirectAttributes ra) {
    if (bindingResult.hasErrors()) {
      ra.addFlashAttribute("shoperror", bindingResult);
      ra.addFlashAttribute("shop",shop);
      ra.addAttribute("id", shop.getId());
      return "redirect:/shop/edit";
    }
    Optional<ShopDto> currentname = shopService.findShopById(id);
    Optional<ShopDto> checkname = shopService.findShopByShopname(shop.getShopname());
    if (checkname.isPresent() && !currentname.get().getShopname().equals(checkname.get().getShopname())) {
      ra.addFlashAttribute("errorMessage", "Tên cửa hàng đã tồn tại");
      ra.addAttribute("id", shop.getId());
      return "redirect:/shop/edit";
    }
    else {
      shopService.saveShop(shop);
      ra.addFlashAttribute("message", "Lưu cửa hàng thành công. ");
      ra.addAttribute("id", shop.getUserid());
      return "redirect:/shop";
    }
  }
  @RequestMapping(value = "/shop/delete")
  public String deleteUser(@RequestParam("id") Integer shopId, RedirectAttributes ra) {
    Optional<ShopDto> s = shopService.findShopById(shopId);
    ra.addAttribute("id", s.get().getUserid());
    productService.deleteProductByIdshop(shopId);
    shopService.deleteShop(shopId);
    return "redirect:/admin";
  }


  @GetMapping("/addproduct")
  public String admin(@RequestParam("id") Integer id, Model model) {
    ShopDto shopDto = shopService.findShopById(id).get();
    model.addAttribute("shop", shopDto);
    return "addproduct";
  }
}
