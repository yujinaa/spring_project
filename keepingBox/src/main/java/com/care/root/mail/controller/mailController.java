package com.care.root.mail.controller;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//127.0.0.1:8080/ROOT/api/mail/confirm.json?email
		@PostMapping(value = "confirm.json",produces = "application/json; charset=utf8")
		public String confirm(@RequestParam(name = "email") String email) throws Exception{
			String code = ms.sendSimpleMessage(email);
			System.out.println("사용자에게 발송한 인증코드 ==> " + code);

			return code;
		}
	}
