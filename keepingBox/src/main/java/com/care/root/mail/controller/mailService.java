package com.care.root.mail.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class mailService {
	@Autowired JavaMailSender mailSender;//JavaMailSender로 mailSender(config)를 빈으로 얻어옴
	public void sendMail(String to, String subject, String body) { //(보내는 곳, 제목, 내용)
		MimeMessage message = mailSender.createMimeMessage();//받는 사용자에 대한 세팅(MimeMessageHelper를 위해 message가 필요한것)
		try {
			//MimeMessageHelper : 실질적으로 사용자에게 보낼 내용을 저장
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");//true : 멀티팟 허용
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
