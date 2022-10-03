package com.care.root.member.service;

import java.sql.Date;

import com.care.root.member.dto.memberDTO;

public interface memberService {
	public int userCheck(String id, String pwd);
	public void keepLogin(String sessionId, Date limitDate, String id);
	public memberDTO getUserSessionId(String sessionId);
	public int register(memberDTO dto);
	public int idCheck(String id);

}
