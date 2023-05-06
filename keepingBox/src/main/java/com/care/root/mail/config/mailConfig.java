package com.care.root.mail.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration//무조건 써야한다
public class mailConfig {
	@Bean
	public JavaMailSender NaverMailService(){

		 JavaMailSenderImpl jms = new JavaMailSenderImpl();
		   jms.setHost("smtp.gmail.com");//google smtp(메일 전송 프로토콜) 서버 설정
		   jms.setPort(587);             //google smtp 메일 포트
		   jms.setUsername("micho4790@gmail.com");//본인 구글 계정 
		   jms.setPassword("381bEA*$cbtmznp");     //본인 구글 비번
	
		//세부 사항
		   Properties prop = new Properties();
		   prop.setProperty("mail.transport.protocol", "smtp");
		   prop.setProperty("mail.smtp.auth", "true");             //사용자 인증
		   prop.setProperty("mail.smtp.starttls.enable", "true");//보안 처리
		   prop.setProperty("mail.debug", "true");//디버그 설정 출력
		   jms.setJavaMailProperties(prop);//설정값 넣기

	        return jms;
	    }
}
