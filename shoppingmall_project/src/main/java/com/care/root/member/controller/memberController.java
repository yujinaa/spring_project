package com.care.root.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class memberController {
	@GetMapping("member/login")
	public String login() {
		System.out.println("회원 로그인 연결");
		return "member/login";
	}

}
