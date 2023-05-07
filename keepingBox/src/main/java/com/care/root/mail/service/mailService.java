package com.care.root.mail.service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//받는 사용자 세팅
@Component
//@Service
public class mailService {
//	@Autowired
//	JavaMailSender mailSender; // MailConfig에서 등록해둔 Bean을 autowired하여 사용하기
//	private int authNumber; 

//		public void sendMail(String to, String subject, String body) { //(보내는 곳, 제목, 내용)
//			MimeMessage message = mailSender.createMimeMessage();//받는 사용자에 대한 세팅(MimeMessageHelper를 위해 message가 필요한것)
//			try {
//				//MimeMessageHelper : 실질적으로 사용자에게 보낼 내용을 저장
//				MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");//true : 멀티팟 허용
//				helper.setTo(to);
//				helper.setSubject(subject);
//				helper.setText(body);
//	
//				mailSender.send(message);
//	
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
	//이메일 인증
	//	public void auth_check(HttpServletRequest request) {
	//		HttpSession session = request.getSession();
	//		String userid = session.getId();
	//		String userkey = rand();      //랜덤키
	//		session.setAttribute(userid, userkey);
	//		String body="<h2>안녕하세요 키핑박스입니다</h2><hr>"  //사용자 이메일로 넘어갈 값
	//				+"<h3>"+userid+" 님</h3>"
	//				+"<p>인증하기 버튼을 누르면 메일 인증이 완료됩니다.</p>"
	//				+"<a href='http://localhost:8084"
	//				+request.getContextPath()+"/auth_check?userid="
	//				+userid+"&userkey="+userkey+"'>인증하기</a>";
	//		sendMail("@naver.com","이메일 인증입니다",body);
	//	}


	//	private String rand() {//랜덤키 메소드 만들어줌
	//		Random ran = new Random();
	//		String str="";
	//		int num;
	//		while(str.length() != 20) {
	//			num = ran.nextInt(75)+48;
	//			if((num>=48 && num<=57)||(num>=65 && num<=90)||(num>=97 && num<=122)) {
	//				str+=(char)num;
	//			}else {
	//				continue;
	//			}
	//		}
	//		return str;
	//	}

//	public void makeRandomNumber() {
//		// 난수의 범위 111111 ~ 999999 (6자리 난수)
//		Random r = new Random();
//		int checkNum = r.nextInt(888888) + 111111;
//		System.out.println("인증번호 : " + checkNum);
//		authNumber = checkNum;
//	}
	//이메일 보낼 양식! 
//	public String joinEmail(String email) {
//		makeRandomNumber();
//		String setFrom = "m"; // email-config에 설정한 자신의 이메일 주소를 입력 
//		String toMail = email;
//		String title = "회원 가입 인증 이메일 입니다."; // 이메일 제목 
//		String content = 
//				"홈페이지를 방문해주셔서 감사합니다." + 	//html 형식으로 작성 ! 
//						"<br><br>" + 
//						"인증 번호는 " + authNumber + "입니다." + 
//						"<br>" + 
//						"해당 인증번호를 인증번호 확인란에 기입하여 주세요."; //이메일 내용 삽입
//		mailSend(setFrom, toMail, title, content);
//		return Integer.toString(authNumber);
//	}

	//이메일 전송 메소드
//	public void mailSend(String setFrom, String toMail, String title, String content) { 
//		MimeMessage message = mailSender.createMimeMessage();
//		// true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
//			helper.setFrom(setFrom);
//			helper.setTo(toMail);
//			helper.setSubject(title);
//			// true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
//			helper.setText(content,true);
//			mailSender.send(message);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}

