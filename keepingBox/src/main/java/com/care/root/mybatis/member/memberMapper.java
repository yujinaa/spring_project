package com.care.root.mybatis.member;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.care.root.member.dto.memberDTO;

public interface memberMapper {
	public memberDTO  userCheck(String id); //dto전달하기
	public void keepLogin(Map<String, Object>map);
	public memberDTO getUserSessionId(String sessionId) ;
	public int register(memberDTO dto);
	public int idCheck(String id);
	
	//회원정보조회
	public memberDTO memberInfo(String id);
	
	//관리자 - 회원목록
	public ArrayList<memberDTO> memberInfoList(@Param("s") int start, @Param("e") int end);
	public int selectMemberCount();
	//관리자-회원삭제
	public void detailInfoDel(String id);

}
