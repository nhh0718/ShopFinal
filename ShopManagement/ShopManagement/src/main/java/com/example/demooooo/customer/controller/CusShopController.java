package com.example.demooooo.customer.controller;

import com.example.demooooo.customer.dto.CusShopDto;
import com.example.demooooo.customer.service.CusShopService;
import com.example.demooooo.dto.UserDto;
import com.example.demooooo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CusShopController {
	@Autowired
	private CusShopService cusShopService;
	@Autowired
	private UserService userService;

	@GetMapping("/search")
	public String search(Model model, @RequestParam("keyword") String keyword, @RequestParam Integer userid, RedirectAttributes redirectAttributes) {
		Optional<CusShopDto> shop = cusShopService.findShopByName(keyword);
		if (shop.isPresent()) {
			model.addAttribute("cusShop", shop.get());
			UserDto userDto = userService.getUserById(userid).get();
			model.addAttribute("user", userDto);
			return "guest";
		} else {
			redirectAttributes.addFlashAttribute("Errors", "Không tìm thấy shop" + " \"" + keyword + "\"");
			redirectAttributes.addAttribute("userid", userid);
			return "redirect:/guest";
		}
	}
}
