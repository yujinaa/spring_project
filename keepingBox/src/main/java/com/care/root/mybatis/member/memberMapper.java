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

	//카카오 회원정보 저장
	public void kakaoInsert(kakaoMemberDTO userInfo);
	
	//카카오 회원정보 가져오기
	public  kakaoMemberDTO findKakao(kakaoMemberDTO userInfo);


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
//	public void deleteMemberCheck(memberDTO dto) throws Exception;
	//	public int delCheck(memberDTO dto);
	//	public void deleteMemberCheck(String delId);
	//	public boolean pwdCheck(String id, String pwd);
//	public void deleteMemberCheck(String pwd);
	//관리자 - 회원목록
	public ArrayList<memberDTO> memberInfoList(@Param("s") int start, @Param("e") int end);
	public int selectMemberCount();
	//관리자-회원삭제
	public int detailInfoDel(String id);
	//검색
	public ArrayList<memberDTO> searchId(@Param("userId")String userId, @Param("s") int start, @Param("e") int end);
	public Integer selectSearchIdCount(String userId);
//	public boolean checkPwd(String delId, String pwd);
//	public void deleteMemberCheck(String id);
//	public memberDTO deleteMemberCheck(String id);
//	public void deleteMemberCheck(@Param("id")String id,@Param("pwd")String pwd);
//	public void deleteMemberCheck(String id);
//	public int deleteMemberCheck(String id);
//	public boolean checkPwd(String id, String pwd);
//	public int deleteMemberCheck(@Param("id") String id, memberDTO member);
//	public int checkPwd(String id, String pwd,Map<String, String> map);
//	public void deleteMemberCheck(String id);
//	public int checkPwd(@Param("id") String id, Map<String, String> map);
//	public void deleteMemberCheck(@Param("id") String id);
//	public boolean checkPwd(@Param("id") String id, @Param("pwd")String pwd,Map<Object, Object> map);
//	public int checkPwd(String string, Map<Object, Object> map);
//	public String checkPwd(String pwd, HttpSession session);
//	public void deleteMemberCheck(memberDTO dto);
//	public int checkPwd(String pwd, String id);
//	public int checkPwd(@Param("pwd")String pwd, @Param("id") String id);
	
	public int deleteMemberCheck(String id);
//	public int deleteMemberCheck(@Param("pwd")String pwd, @Param("id") String id);
//	public int deleteMemberCheck(@Param("id") String id);
	
//	public void deleteMemberCheck(String id);
//	public int checkPwd(@Param("pwd")String pwd, @Param("id") String id);
//	public boolean checkPwd(String id, String pwd);
//	public void deleteMemberCheck(String pwd);
//	public int checkPwd(@Param("pwd")String pwd, @Param("id") String id);
//	public void deleteMemberCheck(String id);
//	public void deleteMemberCheck(String id);
//	public int checkPwd(memberDTO member)throws Exception;
//	public void deleteMemberCheck(String id);
//	public int checkPwd(String pwd, String id);
//	public int checkPwd(String id,String pwd, Map<String, String> map);
//	public int checkPwd(String id,String pwd);
//	public int checkPwd(@Param("id") String id, Map<Object, Object> map);
//	public int checkPwd(@Param("pwd")String pwd, @Param("id") String id);
}
