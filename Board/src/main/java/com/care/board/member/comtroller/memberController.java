package com.care.board.member.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@PostMapping("user_check")
	public String userCheck(@RequestParam(required = false) String userId, @RequestParam String userPwd) {
		int result = ms.userCheck(userId,userPwd);
		if(result==0) { //성공
			return "redirect:/list";
		}else {//실패
			return "redirect:login";
		}
	}
}
