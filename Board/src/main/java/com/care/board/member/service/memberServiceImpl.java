package com.care.board.member.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.board.member.dto.memberDTO;
import com.care.board.mybatis.member.MemberMapper;

@Service
public class memberServiceImpl implements memberService{
	@Autowired MemberMapper mapper; //빈주입
	BCryptPasswordEncoder psencoder; //비번 암호화,변경

	public memberServiceImpl(){//객체 생성후 생성자 만들기
		psencoder = new BCryptPasswordEncoder();
	}
	public int userCheck(String userId, String userPwd) {
		memberDTO dto = mapper.userCheck(userId);
		if(dto != null) {//데이터 있음
			//if(userPwd.equals(dto.getUserPwd())) {
			if(psencoder.matches(userPwd, dto.getUserPwd())) { //암호화된 비번을 원래비번과 비교하기(앞은 사용자입력값, 뒤는 암호화된값)
				return 0; //로그인 성공
			}
		}
		return 1; //실패
	}
	public int signUp(memberDTO dto) {
		//비번 암호화 코드
		System.out.println("비번 변경전 : " + dto.getUserPwd());
		String securePwd = psencoder.encode(dto.getUserPwd());
		System.out.println("비번 변경 후 : " + securePwd);

		dto.setUserPwd(securePwd); //암호 변경

		int result = 0;
		try {//동일 id로 가입시 프로그램은 계속되도록
			result = mapper.signUp(dto);			
		} catch (Exception e) {
			e.printStackTrace(); //콘솔메시지 띄우기
		}
		return result;
	}
	public void keepLogin(String sessionId, Date limitDate,String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sessionId", sessionId);
		map.put("limitDate", limitDate);
		map.put("userId", userId);
		mapper.keepLogin(map);
	}
}

