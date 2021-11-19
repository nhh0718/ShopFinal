package com.example.demooooo.product.controller;

import com.example.demooooo.product.dto.ProductDTO;
import com.example.demooooo.product.model.Product;
import com.example.demooooo.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping("/product")
    public String getAllProduct(@RequestParam("id") Integer id, Model model, RedirectAttributes ra) {
        List<ProductDTO> check = productService.findProductByShopId(id);
        if (check != null) {
            model.addAttribute("product", check);
            model.addAttribute("idshop", id);
            return "product";
        } else {
            return "loi";
        }

    }

    @RequestMapping("product/addproduct")
    public String addProduct(@RequestParam("id") Integer idshop, Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("idshop", idshop);
        return "addproduct";
    }


    @PostMapping("product/save")
    public String saveProduct(ProductDTO productDTO, RedirectAttributes redirectAttributes) {
        productService.saveProduct(productDTO);
        redirectAttributes.addAttribute("id", productDTO.getIdshop());
        return "redirect:/product";
    }

    @RequestMapping("product/delete")
    public String deleteProduct(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Optional<ProductDTO> productDTO = productService.findProductById(id);
        redirectAttributes.addAttribute("id", productDTO.get().getIdshop());
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @RequestMapping(value = "product/update", method = RequestMethod.GET)
    public String updateProduct(@RequestParam("id") Integer productid, Model model) {
        Optional<ProductDTO> productUpdate = productService.findProductById(productid);
        model.addAttribute("idshop", productUpdate.get().getIdshop());
        productUpdate.ifPresent(product -> model.addAttribute("product", product));
        return "editProduct";
    }

}
