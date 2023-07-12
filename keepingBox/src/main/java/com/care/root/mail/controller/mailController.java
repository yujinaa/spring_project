package com.care.root.mail.controller;

import java.util.Random;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mailController {
	@Autowired  //의존성 주입을 사용
	private JavaMailSender mailSender;//JavaMailSender 객체 타입인 mailSender 변수를 선언

	@RequestMapping(value = "member/mailCheck", method =  RequestMethod.GET )	
	//	@GetMapping(value="member/mailCheck",produces = "application/json; charset=utf8")
	@ResponseBody
	public String mailCheck(String email) throws Exception{ //반환값이 있기에 메서드 타입도 String
		System.out.println("이메일 데이터 전송 확인");  
		System.out.println("인증 이메일 : " + email);  

		//인증번호 랜덤생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		System.out.println("인증번호 :"+ checkNum);

		//이메일 전송 내용
		String setFrom = "@gmail.com";
		String toMail = email;
		String title = "KeepingBox 회원가입 인증 이메일 입니다.";
		String content = 
				"홈페이지를 방문해주셔서 감사합니다." +
						"<br><br>" + 
						"인증 번호는 " + checkNum + "입니다." + 
						"<br>" + 
						"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		//이메일 전송 코드
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);

		}catch(Exception e) {
			e.printStackTrace();
		}
		String num = Integer.toString(checkNum); // ajax를 뷰로 반환시 데이터 타입은 String 타입만 가능
		return num; // String 타입으로 변환 후 반환
	}
}

