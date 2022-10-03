package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.common.memberLoginSession;
import com.care.root.member.service.memberService;

@Controller
@RequestMapping("member")
public class memberController implements memberLoginSession{
	@Autowired memberService ms;
	//로그인클릭
	@GetMapping("login")
	public String login() {
		System.out.println("로그인페이지이동");
		return "member/login";
	}
	//로그인시 확인
	@PostMapping("user_check")
	public String userCheck(@RequestParam  String id, @RequestParam  String pwd,
//			@RequestParam(required = false) String autoLogin, //자동로그인
			RedirectAttributes rs) {  //id, pwd 받아줄것
		int result = ms.userCheck(id,pwd); //서비스로 id,pwd넘기기
		System.out.println("result : " +result); //result확인
//		System.out.println("autoLogin : " + autoLogin);

		//result=0이면 성공(rs로 id, autoLogin넘기기)
		if(result == 0) {
			rs.addAttribute("id",id);
//			rs.addAttribute("autoLogin",autoLogin);
			return "redirect:successCheckLogin"; //바로 로그인성공페이지
		}else { //로그인 체크 실패시
			return "redirect:login"; //다시 로그인페이지로
		}
	}

}
