package com.care.root.mybatis.member;

import com.care.root.member.dto.memberDTO;

public interface memberMapper {
	public memberDTO  userCheck(String id); //dto전달하기

}
