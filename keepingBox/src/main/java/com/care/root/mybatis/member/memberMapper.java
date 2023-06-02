package com.care.root.mybatis.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.care.root.board.dto.boardDTO;
import com.care.root.board.dto.noticeDTO;
import com.care.root.member.dto.kakaoMemberDTO;
import com.care.root.member.dto.memberDTO;

public interface memberMapper {
	public memberDTO  userCheck(String id); //dto전달하기
	public void keepLogin(Map<String, Object>map);
	public memberDTO getUserSessionId(String sessionId) ;

	//	public void kakaoInsert(HashMap<String, Object>userInfo);
	public void kakaoInsert(kakaoMemberDTO userInfo);
	//	public  HashMap<String, Object> findKakao(HashMap<String, Object> userInfo);
	public  kakaoMemberDTO findKakao(kakaoMemberDTO userInfo);
	//	public kakaoMemberDTO KakaoLoginChk(String email);


	public int register(memberDTO dto);
	public int idCheck(String id);

	//회원정보조회
	public memberDTO memberInfo(String memberId);

	//내가 쓴글
	public memberDTO getInfo(String id);

	
	//회원정보수정
	public int modifySave(memberDTO dto);
	//아이디찾기
	public memberDTO findMemberId(memberDTO dto);
	//비번찾기
	public int pwdCheck(memberDTO dto);
	//	public void pwdUpdate(memberDTO dto);
	public void pwdUpdate(memberDTO dto);
	//회원탈퇴
	public void deleteMemberCheck(memberDTO dto);
	//	public int delCheck(memberDTO dto);
	//	public void deleteMemberCheck(String delId);
	//	public boolean pwdCheck(String id, String pwd);
	public void deleteMemberCheck(String pwd);
	//관리자 - 회원목록
	public ArrayList<memberDTO> memberInfoList(@Param("s") int start, @Param("e") int end);
	public int selectMemberCount();
	//관리자-회원삭제
	public void detailInfoDel(String id);
	//검색
	public ArrayList<memberDTO> searchId(@Param("userId")String userId, @Param("s") int start, @Param("e") int end);
	public Integer selectSearchIdCount(String userId);

}
