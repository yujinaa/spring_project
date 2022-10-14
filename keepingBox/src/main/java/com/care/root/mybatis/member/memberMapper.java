package com.care.root.mybatis.member;

import java.util.Map;

import com.care.root.member.dto.memberDTO;

public interface memberMapper {
	public memberDTO  userCheck(String id); //dto전달하기
	public void keepLogin(Map<String, Object>map);
	public memberDTO getUserSessionId(String sessionId) ;
	public int register(memberDTO dto);
	public int idCheck(String id);
	
	//회원정보조회
	public memberDTO memberInfo(String id);
}
