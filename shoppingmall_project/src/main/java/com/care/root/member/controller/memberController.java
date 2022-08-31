package com.care.root.member.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.common.memberSessionName;
import com.care.root.member.service.memberService;

@Controller
@RequestMapping("member") //시작경로가 member라 공통으로 쓰기
public class memberController implements memberSessionName{ //편하게 쓰기 위해 상속받았다.
	@Autowired memberService ms; //서비스로 넘기기위해 
	@GetMapping("/login") //로그인페이지 맵핑
	public String login() {
		System.out.println("회원 로그인 연결"); 
		return "member/login";
	}
	@PostMapping("/user_check") //로그인 버튼 클릭시 id,pwd 넘어온값 userCheck로 받기
	public String userCheck(@RequestParam String id, @RequestParam String pw, //requestparam으로 넘어온값 받아주었다
								RedirectAttributes rs){
		int result = ms.userCheck(id,pw); //서비스 연결해서 id,pw넘기기. 돌아올 결과값은 result로받기
		if(result==0){//로그인 성공(결과값 result가 0이면 성공)
			rs.addAttribute("id",id); //redirect를 통해서 id넘기기  (jsp로 넘어가는게 아니라 model로 써도 돼는데 그냥addAttribute 쓰기로결정
			return "redirect:successLogin"; //바로 로그인성공페이지로 이동
		}else{//로그인 실패(결과값 result가 0이 아니면 실패)
			return "redirect:login"; // 바로 로그인페이지로 이동해서 다시 로그인하게끔
		}		
	}
	@GetMapping("/successLogin") //로그인 성공시 
	public String successLogin(@RequestParam String id, HttpSession session) {//넘어오는 id받기
		session.setAttribute(LOGIN, id);
		return "member/successLogin";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) { //로그인성공유저 세션을 가져와서
		if(session.getAttribute(LOGIN)!=null) //로그인세션값이 있다면
			session.invalidate();  //세션만료(로그아웃)
		return "redirect:/index";//로그아웃하면 기본 index페이지로 이동
								//(절대경로/붙이기 -> 그냥 index만쓰면 상대경로라 member의 index로 읽는다.이건 그냥 index)
	}
	@GetMapping("join_form")
	public String registerForm() {
		return "member/join_form";
	}
	
//	@GetMapping("/register")
//		public String account() {
//		System.out.println("회원 회원가입 연결");
//		return "member/account";
//	}
	
	

}
