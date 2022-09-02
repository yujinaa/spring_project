package com.care.root.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class productController {
	@GetMapping("/outer")
	public String outer() {
		System.out.println("아우터 페이지 연결");
		return "product/outer";
	}
}
