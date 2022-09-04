package com.care.root.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.admin.service.adminService;
import com.care.root.common.memberSessionName;

@Controller
@RequestMapping("admin")
public class adminController implements memberSessionName{
	@Autowired adminService as;
	
	//로그인페이지연결
	@GetMapping("admin_login")
	public String login() {
		System.out.println("관리자 로그인 연결"); 
		return "admin/admin_login";
	}
	@PostMapping("admin_check")
	public String adminCheck(@RequestParam String id, @RequestParam String pwd, RedirectAttributes ra) {
		int result = as.adminCheck(id,pwd);
		if(result==0) {
			ra.addAttribute("id",id);
			return "redirect:successAdmin";
		}else {
			return "redirect:admin_login";
		}
	}
		@GetMapping("successAdmin") //로그인 성공시 
		public String successAdmin(@RequestParam String id, HttpSession session) {
			System.out.println("관리자 로그인성공");
			session.setAttribute(LOGIN, id);
			return "admin/successAdmin";
		}
		
		
	}

