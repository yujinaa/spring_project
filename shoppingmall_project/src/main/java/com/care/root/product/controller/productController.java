package com.care.root.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class productController {
	
	@GetMapping("outer")
	public String productList() {
		return "product/outer";
	}
}
