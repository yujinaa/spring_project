package com.care.root.mybatis.member;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.care.root.member.dto.memberDTO;

public interface memberMapper {
	public memberDTO  userCheck(String id); //dto전달하기
	public void keepLogin(Map<String, Object>map);
	public memberDTO getUserSessionId(String sessionId) ;
	public int register(memberDTO dto);
	public int idCheck(String id);

	//회원정보조회
	public memberDTO memberInfo(String memberId);
	//	public memberDTO memberInfo(String id) ;
	//	public String memberInfo(String id) ;
	
	//회원정보수정
	public int modifySave(memberDTO dto);
	//아이디찾기
	public memberDTO findMemberId(memberDTO dto);
	//비번찾기
	public int pwdCheck(memberDTO dto);
	public void pwdUpdate(memberDTO dto);
		
	//관리자 - 회원목록
	public ArrayList<memberDTO> memberInfoList(@Param("s") int start, @Param("e") int end);
	public int selectMemberCount();
	//관리자-회원삭제
	public void detailInfoDel(String id);
	//검색
	public ArrayList<memberDTO> searchId(@Param("userId")String userId, @Param("s") int start, @Param("e") int end);
	public Integer selectSearchIdCount(String userId);

}
