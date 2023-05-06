package com.care.root.mail.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
//받는 사용자 세팅
@Service
public class mailService{
	@Autowired
	JavaMailSender mailSender; // MailConfig에서 등록해둔 Bean을 autowired하여 사용하기

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
	//이메일 인증
	public void auth_check(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userid = session.getId();
		String userkey = rand();      //랜덤키
		session.setAttribute(userid, userkey);
		String body="<h2>안녕하세요 키핑박스입니다</h2><hr>"  //사용자 이메일로 넘어갈 값
				+"<h3>"+userid+" 님</h3>"
				+"<p>인증하기 버튼을 누르면 메일 인증이 완료됩니다.</p>"
				+"<a href='http://localhost:8084"
				+request.getContextPath()+"/auth_check?userid="
				+userid+"&userkey="+userkey+"'>인증하기</a>";
		sendMail("ehfkqkd4879@naver.com","이메일 인증입니다",body);
	}


	private String rand() {//랜덤키 메소드 만들어줌
		Random ran = new Random();
		String str="";
		int num;
		while(str.length() != 20) {
			num = ran.nextInt(75)+48;
			if((num>=48 && num<=57)||(num>=65 && num<=90)||(num>=97 && num<=122)) {
				str+=(char)num;
			}else {
				continue;
			}
		}
		return str;
	}
}
