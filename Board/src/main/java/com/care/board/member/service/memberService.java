package com.care.board.member.service;

import com.care.board.member.dto.memberDTO;

public interface memberService {
	public int userCheck(String userId, String userPwd);
	public int signUp(memberDTO dto);

}
