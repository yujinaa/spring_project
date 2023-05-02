package com.care.root.mail.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mailController {
	@Autowired mailService ms;
	@GetMapping("sendmail")
	public void sendMail(HttpServletResponse response) throws Exception {// printwriter때문에 예외처리

		//메일 전송("전송하고자 하는 이메일주소","제목","내용")
		ms.sendMail("@naver.com","(제목)테스트 메일","(내용)안녕하세요");

		response.setContentType("text/html;charset=utf-8");//응답 방법
		PrintWriter out = response.getWriter();
		out.print("메일이 전송되었습니다");
	}
}
