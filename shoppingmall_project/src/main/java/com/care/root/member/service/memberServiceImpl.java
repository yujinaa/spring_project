package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.memberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class memberServiceImpl implements memberService{
	@Autowired MemberMapper mapper;             //mapper연결을 위해 autowired로 주입
	BCryptPasswordEncoder pwEncoder; //비번 암호화하기
	
	public memberServiceImpl() {//생성자 만들어서 확인하기
		pwEncoder = new BCryptPasswordEncoder();
	}
	
	public int userCheck(String id,String pw) {		//서비스 인터페이스 값 오버라이딩하기. 사용자 입력값
		memberDTO dto =  mapper.userCheck(id); //mapper로 id연결해서 db dto에 넣기
		if(dto != null){//dto가 null이 아니면 해당 id는 존재(데이터 있는것)
			//if(pw.equals(dto.getPw())) {//사용자가 입력한 pw와 db에서 가져온 pw가 같다면
			if(pwEncoder.matches(pw, dto.getPw())) { //해당 인코더를 이용해 암호회된 비번을 비교(암호화되지않은입력값,암호화된값)
				return 0; //로그인성공시 0 돌려주기
			}
		}
		return 1; //그렇지 않다면 로그인실패로 1 돌려주기
	}
	public int join(memberDTO dto) {//회원가입
		System.out.println("pw 변경전 : " + dto.getPw());
		String securePw = pwEncoder.encode(dto.getPw());//비번 암호화하기
		System.out.println("pw 변경 후 : " + securePw);
		dto.setPw(securePw); //암호회된 비번을 다시 dto에 넣기
		
		int result = 0;
		try { //동일 id로 회원가입시 발생하는 문제 처리하기
			result = mapper.join(dto); //예외처리발생(프로그램 종료되지 말고 흘러가도록)
		} catch (Exception e) {
			e.printStackTrace(); //개발자만 볼수있게 프로그램 흐름을 깨지않도록 
		}
		return result;
	}
}
