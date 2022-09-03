package com.care.root.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class adminController {
	@GetMapping("admin_login")
	public String login() {
		System.out.println("관리자 로그인 연결"); 
		return "admin/admin_login";
	}

}
