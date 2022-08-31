package com.care.root.member.service;

import com.care.root.member.dto.memberDTO;

public interface memberService {
	public int userCheck(String id,String pw); //컨트롤러에서 int(result)값 받기위해 반환값을 int로 써주었다. 
	public int join(memberDTO dto);
}
