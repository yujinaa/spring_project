package com.care.board.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.board.member.dto.memberDTO;
import com.care.board.mybatis.member.MemberMapper;

@Service
public class memberServiceImpl implements memberService{
	@Autowired MemberMapper mapper; //빈주입
	public int userCheck(String userId, String userPwd) {
		memberDTO dto = mapper.userCheck(userId);
		if(dto != null) {//데이터 있음
			if(userPwd.equals(dto.getUserPwd())) {
				return 0; //로그인 성공
			}
		}
			return 1; //실패
		}
	public int signUp(memberDTO dto) {
		int result = 0;
		result = mapper.signUp(dto);
		return result;
	}
}

