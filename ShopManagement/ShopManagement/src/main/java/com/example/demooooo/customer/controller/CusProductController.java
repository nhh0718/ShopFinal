package com.example.demooooo.customer.controller;

import com.example.demooooo.customer.dto.CusProductDto;
import com.example.demooooo.customer.dto.CusShopDto;
import com.example.demooooo.customer.service.CusProductService;
import com.example.demooooo.customer.service.CusShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CusProductController {
    @Autowired
    private CusProductService cusProductService;
    @Autowired private CusShopService cusShopService;

    @GetMapping("shopform")
    public String index(@RequestParam("id") Integer id, @RequestParam Integer userid, Model model) {
        List<CusProductDto> check = cusProductService.findProductByIdshop(id);
        Optional<CusShopDto> shopbyid = cusShopService.findShopById(id);
        model.addAttribute("shopbyid", shopbyid.get());
        if (check.size() != 0) {
            model.addAttribute("cusProduct", check);
            model.addAttribute("idshop", id);
            model.addAttribute("userid", userid);
            return "shopform";
        } else {
            model.addAttribute("userid", userid);
            return "NotFound";
        }
    }

    @GetMapping("/sortproduct")
    public String sort(@RequestParam("id") Integer id, @RequestParam Integer userid, Model model) {
        List<CusProductDto> check = cusProductService.sortProduct(id);
        Optional<CusShopDto> shopbyid = cusShopService.findShopById(id);
        model.addAttribute("shopbyid", shopbyid.get());
            model.addAttribute("cusProduct", check);
            model.addAttribute("idshop", id);
            model.addAttribute("userid", userid);
            return "shopform";
    }

    @GetMapping("/buy")
    public String Buy(@RequestParam Integer[] productid,
                      @RequestParam Integer[] soluong,
                      @RequestParam Integer idshop,
                      @RequestParam Integer userid,
                      RedirectAttributes ra) {
        boolean over = false;
        for (int j = 0; j < productid.length; j++) {
            Optional<CusProductDto> check = cusProductService.findProductById(productid[j]);
            if ((check.get().getQuantity() - 10) < soluong[j]) {
                ra.addFlashAttribute("quantityNotE", "Số lượng hàng không được dưới 10 sản phẩm");
                over = true;
                break;
            }
        }
        if(!over) {
            int total = 0;
            for (int i = 0; i < productid.length; i++) {
                Optional<CusProductDto> check = cusProductService.findProductById(productid[i]);
                check.get().setQuantity(check.get().getQuantity() - soluong[i]);
                check.get().setSelledquantity(check.get().getSelledquantity() + soluong[i]);
                cusProductService.saveProduct(check.get());
                total += soluong[i];
            }
            Optional<CusShopDto> shopDto = cusShopService.findShopById(idshop);
            shopDto.get().setTotalselledproduct(shopDto.get().getTotalselledproduct() + total);
            cusShopService.saveShop(shopDto.get());
            ra.addAttribute("id", idshop);
            ra.addAttribute("userid", userid);
            if(total == 0){
                ra.addFlashAttribute("buy0", "Bạn chưa nhập số lượng.");
            }else {
                ra.addFlashAttribute("buysuccess", "Mua hàng thành công.");
            }
            return "redirect:/shopform";
        }
        ra.addAttribute("id", idshop);
        ra.addAttribute("userid", userid);
        return "redirect:/shopform";
    }
}
