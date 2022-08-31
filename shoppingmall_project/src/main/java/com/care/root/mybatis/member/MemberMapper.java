package com.care.root.mybatis.member;

import com.care.root.member.dto.memberDTO;

public interface MemberMapper {
	public memberDTO userCheck(String id); //dto값 전달. 이 mapper파일은 xml 파일과 연결된다.

}
