package com.care.root.member.service;

import java.sql.Date;

import org.springframework.ui.Model;

import com.care.root.member.dto.memberDTO;

public interface memberService{
	public int userCheck(String id, String pwd);
	public void keepLogin(String sessionId, Date limitDate, String id);
	public memberDTO getUserSessionId(String sessionId);
	public int register(memberDTO dto);
	public int idCheck(String id);
	
	//회원정보조회
//	public int memberInfo(Model model, String sessionId);
//	public memberDTO memberInfo(String id); 
	public memberDTO memberInfo(String userId); 
	
	
	//관리자- 회원목록
	public void memberInfoList(Model model,int num);

}
