package com.care.root.member.service;

import java.sql.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.care.root.board.dto.boardDTO;
import com.care.root.board.dto.noticeDTO;
import com.care.root.member.dto.memberDTO;

public interface memberService{
	public int userCheck(String id, String pwd);
	public void keepLogin(String sessionId, Date limitDate, String id);
	public memberDTO getUserSessionId(String sessionId);
	public int register(memberDTO dto);
	public int idCheck(String id);

	//회원정보조회
	public memberDTO memberInfo(String id); 

	//내가 쓴 글
	public memberDTO getInfo(String id);

	//회원정보수정
	//회원정보가져오기
	public void updateMember(String id, Model model);
	public int modifySave(memberDTO dto);
	//아이디찾기
	public memberDTO findMemberId(memberDTO dto);

	//비번찾기
	public int pwdCheck(memberDTO dto);
	public void pwdUpdate(memberDTO dto);
	//탈퇴
//	public int deleteMemberCheck(String id);
	public int deleteMemberCheck(String id);
//	public int deleteMemberCheck(String id,String pwd);
	
	//관리자- 회원목록
	public void memberInfoList(Model model,int num);
	public void detailInfo(Model model, String id);
	public void detailInfoDel(String id);
	public void searchId(Model model, String userId, int num);

}
