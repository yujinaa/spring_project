package com.care.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class memberController {
	@RequestMapping("member")
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}

}
