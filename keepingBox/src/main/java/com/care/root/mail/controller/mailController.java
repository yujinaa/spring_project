package com.care.root.mail.controller;

import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.mail.service.mailService;
import com.care.root.mail.service.mailServiceImpl;

@RestController
public class mailController {
//	@Autowired
//	private mailService ms;
	@Autowired  //의존성 주입을 사용
	private JavaMailSender mailSender;//JavaMailSender 객체 타입인 mailSender 변수를 선언


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

//		return ms.joinEmail(email);
//		int serti = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
//
//		String from = "@gmail.com";//보내는 이 메일주소
//		String to = email;
//		String title = "회원가입시 필요한 인증번호 입니다.";
//		String content = "[인증번호] "+ serti +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
//		String num = "";
//		try {
//			MimeMessage mail = mailSender.createMimeMessage();
//			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
//
//			mailHelper.setFrom(from);
//			mailHelper.setTo(to);
//			mailHelper.setSubject(title);
//			mailHelper.setText(content, true);       
//
//			mailSender.send(mail);
//			num = Integer.toString(serti);
//
//		} catch(Exception e) {
//			num = "error";
//		}
//		return num;


//		//	@GetMapping("sendMail")
//		//	public String authCheck(@RequestParam String userid, @RequestParam String userkey,
//		//			HttpSession session) {
//		//
//		//		String sessionKey = (String)session.getAttribute(userid);
//		//		if(sessionKey != null) {
//		//			if(sessionKey.equals(userkey)) {
//		//				session.setAttribute("userid", userid);
//		//			}
//		//		}
//		//		return "redirect:register_form";
//		//	}
