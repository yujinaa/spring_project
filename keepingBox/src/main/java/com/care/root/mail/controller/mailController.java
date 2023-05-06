package com.care.root.mail.controller;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.mail.service.mailService;

@RestController
@ResponseBody
public class mailController {
	@Autowired
	mailService ms;

//	@GetMapping("auth_check")
//	public void sendMail(HttpServletResponse response) throws Exception { //printwriter때문에 예외처리
//
//		//메일 전송("전송하고자 하는 이메일주소","제목","내용")
//		ms.sendMail("","(제목)인증 메일입니다","(내용)회원가입을 위해 메일 인증을 해주세요.");
//
//		response.setContentType("text/html;charset=utf-8");//응답 방법
//		PrintWriter out = response.getWriter();
//		out.print("메일이 전송되었습니다");
//	}
	@GetMapping("member/mailCheck")
	@ResponseBody
	public void mailCheck(String email) {
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
	}


//	@GetMapping("sendMail")
//	public String authCheck(@RequestParam String userid, @RequestParam String userkey,
//			HttpSession session) {
//
//		String sessionKey = (String)session.getAttribute(userid);
//		if(sessionKey != null) {
//			if(sessionKey.equals(userkey)) {
//				session.setAttribute("userid", userid);
//			}
//		}
//		return "redirect:register_form";
//	}
}
