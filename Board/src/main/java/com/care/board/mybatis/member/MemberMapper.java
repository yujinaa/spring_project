package com.care.board.mybatis.member;

import java.util.Map;

import com.care.board.member.dto.memberDTO;

public interface MemberMapper {
	public memberDTO userCheck(String userId); //dto값 전달
	public int signUp(memberDTO dto);
	public void keepLogin(Map<String, Object> map);

}
