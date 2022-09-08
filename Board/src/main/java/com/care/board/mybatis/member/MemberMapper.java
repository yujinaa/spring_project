package com.care.board.mybatis.member;

import com.care.board.member.dto.memberDTO;

public interface MemberMapper {
	public memberDTO userCheck(String userId); //dto값 전달
	public int signUp(memberDTO dto);

}
