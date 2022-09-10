package com.care.board.member.comtroller;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.board.commonSession.loginSessionName;
import com.care.board.member.dto.memberDTO;
import com.care.board.member.service.memberService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("member")
public class memberController implements loginSessionName{
	@Autowired memberService ms;
	@GetMapping("login")
	public String login() {
		System.out.println("로그인 연결");
		return "member/login";
	}
	
	//로그인 체크
	@PostMapping("user_check")   
	public String userCheck(@RequestParam String userId, @RequestParam String userPwd, @RequestParam(required = false) String autoLogin, RedirectAttributes rs) {
		int result = ms.userCheck(userId,userPwd);
		System.out.println("autoLogin : " + autoLogin );
		if(result==0) { //성공
			rs.addAttribute("userId", userId); //controller까지만 연결하기위해 model사용, jsp까지 보내려면 redirectAttributes
			rs.addAttribute("autoLogin", autoLogin);
			return "redirect:loginSuccess";
		}else {//실패
			return "redirect:login";
		}
		}
	
	//로그인 성공시 이동 페이지
	@GetMapping("loginSuccess")
	public String loginSuccess(@RequestParam String userId, @RequestParam(required = false) String autoLogin,HttpSession session) {//세션
		System.out.println("id : " + userId);
		System.out.println("autoLogin : " + autoLogin);
		session.setAttribute(LOGIN, userId);
		return "index";
	
}
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute(LOGIN)!=null) //세션이 있으면
			session.invalidate(); //세션 종료
		System.out.println("로그아웃성공");
		return "redirect:/index";
	}
	//회원가입 페이지이동
	@GetMapping("signUp")
	public String signUp() {
		return "member/signUp";
	}
	//회원가입
	@PostMapping("signUp")
	public String signUp(memberDTO dto) {
		int result = ms.signUp(dto);
		if(result==1) {
			//회원가입 성공
			return "redirect:login";
		}else {
			return "redirect:signUp";
		}
	}
}

//	@PostMapping("user_check")
//	public String userCheck(@RequestParam String userId, @RequestParam String userPwd, RedirectAttributes rs) {
//		int result = ms.userCheck(userId,userPwd);
//		if(result==0) { //성공
//			rs.addAttribute("userId", userId); //controller까지만 연결하기위해 model사용, jsp까지 보내려면 redirectAttributes
//			return "redirect:successLogin";
//		}else {//실패
//			return "redirect:login";
//		}
//		}
	
//	@GetMapping("successLogin")
//	public String index(@RequestParam String userId, HttpSession session) {
//		session.setAttribute("userId", userId);
//		return "member/successLogin";
//	}
//	}