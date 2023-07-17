package com.care.board.member.service;

import java.sql.Date;

import com.care.board.member.dto.memberDTO;

public interface memberService {
	public int userCheck(String userId, String userPwd);
	public int signUp(memberDTO dto);
	public void keepLogin(String sessionId, Date limitDate,String userId);
}
