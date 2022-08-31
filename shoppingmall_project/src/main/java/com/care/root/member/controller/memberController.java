package com.care.root.member.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.service.memberService;

@Controller
public class memberController {
	@Autowired memberService ms; //서비스로 넘기기위해 
	@GetMapping("member/login") //로그인페이지 맵핑
	public String login() {
		System.out.println("회원 로그인 연결"); 
		return "member/login";
	}
	@PostMapping("member/user_check") //로그인 버튼 클릭시 id,pwd 넘어온값 userCheck로 받기
	public String userCheck(@RequestParam String id, @RequestParam String pw, //requestparam으로 넘어온값 받아주었다
								RedirectAttributes rs){
		int result = ms.userCheck(id,pw); //서비스 연결해서 id,pw넘기기. 돌아올 결과값은 result로받기
		if(result==0){//로그인 성공(결과값 result가 0이면 성공)
			return "redirect:successLogin"; //바로 로그인성공페이지로 이동
		}else{//로그인 실패(결과값 result가 0이 아니면 실패)
			return "redirect:login"; // 바로 로그인페이지로 이동해서 다시 로그인하게끔
		}		
	}
	
	@GetMapping("member/register")
		public String account() {
		System.out.println("회원 회원가입 연결");
		return "member/account";
	}

}
