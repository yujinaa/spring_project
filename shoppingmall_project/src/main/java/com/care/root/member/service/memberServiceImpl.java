package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.memberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class memberServiceImpl implements memberService{
	@Autowired MemberMapper mapper;             //mapper연결을 위해 autowired로 주입
	
	public int userCheck(String id,String pw) {		//서비스 인터페이스 값 오버라이딩하기. 사용자 입력값
		memberDTO dto =  mapper.userCheck(id); //mapper로 id연결해서 db dto에 넣기
		if(dto != null){//dto가 null이 아니면 해당 id는 존재(데이터 있는것)
			if(pw.equals(dto.getPw())) {//사용자가 입력한 pw와 db에서 가져온 pw가 같다면
				return 0; //로그인성공시 0 돌려주기
			}
		}
		return 1; //그렇지 않다면 로그인실패로 1 돌려주기
	}
}
