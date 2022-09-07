package com.care.board.member.comtroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.board.member.service.memberService;

@Controller
@RequestMapping("member")
public class memberController {
	@Autowired memberService ms;
	@GetMapping("login")
	public String login() {
		System.out.println("로그인 연결");
		return "member/login";
	}
	
	//로그인 체크
	@PostMapping("user_check")   
	public String userCheck(@RequestParam String userId, @RequestParam String userPwd, RedirectAttributes rs) {
		int result = ms.userCheck(userId,userPwd);
		if(result==0) { //성공
			rs.addAttribute("userId", userId); //controller까지만 연결하기위해 model사용, jsp까지 보내려면 redirectAttributes
			return "redirect:/index";
		}else {//실패
			return "redirect:login";
		}
		}
	
	//로그인 성공시 이동 페이지
	@GetMapping("/index")
	public String index(@RequestParam String userId, HttpSession session) {//세션
		session.setAttribute("loginSuccessUser", userId);
		return "index";
	
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
//	
//	@GetMapping("successLogin")
//	public String index(@RequestParam String userId, HttpSession session) {
//		session.setAttribute("userId", userId);
//		return "member/successLogin";