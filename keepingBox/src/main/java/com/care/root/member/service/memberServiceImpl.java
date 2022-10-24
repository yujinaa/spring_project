package com.care.root.member.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.board.dto.noticeDTO;
import com.care.root.member.dto.memberDTO;
import com.care.root.mybatis.member.memberMapper;

@Service
public class memberServiceImpl implements memberService{
	@Autowired memberMapper memberMapper; //매퍼 연결하기
	BCryptPasswordEncoder pwEncoder; //암호화

	public memberServiceImpl() {
		pwEncoder = new BCryptPasswordEncoder();
	}

	public int userCheck(String id, String pwd) {
		memberDTO dto =  memberMapper.userCheck(id);
		if(dto !=null) {//dto가 있다면
			if(pwEncoder.matches(pwd, dto.getPwd())) { //사용자값, dto에 있는 값 비교하기
				return 0;//성공
			}
		}
		return 1;//실패하면 1반환
	}
	public void keepLogin(String sessionId, Date limitDate, String id) {
		Map<String, Object>map = new HashMap<String, Object>();   //map으로 만들었다.
		map.put("sessionId", sessionId);
		map.put("limitDate", limitDate);
		map.put("id",id);
		memberMapper.keepLogin(map);//맵퍼로 넘기기
	}
	public memberDTO getUserSessionId(String sessionId) {
		return memberMapper.getUserSessionId(sessionId);
	}
	public int register(memberDTO dto) {
		//비번 암호화하기
		System.out.println("비번 변경 전 : " + dto.getPwd());
		String securePwd = pwEncoder.encode(dto.getPwd());
		System.out.println("비번 변경 후 : " + securePwd);

		dto.setPwd(securePwd); //jsp 적용

		int result = 0;          
		String msg = "";
		try { //동일 아이디로 가입시 오류나는 것을 예외로 처리
			result = memberMapper.register(dto);
			msg = "회원가입 되었습니다";
		} catch (Exception e) {
			msg = "회원가입에 실패했습니다";
			e.printStackTrace();
		}
		return result;
	}
	//아이디 중복 조회
	public int idCheck(String id) {
		int count = memberMapper.idCheck(id);
		return count;
	}

	//회원정보조회
	//	public String memberInfo(Model model, String userId){
	//		model.addAttribute("info", memberMapper.memberInfo(id));
	////	}
	//		public memberDTO memberInfo(String id){
	//			return memberMapper.memberInfo(id);
	//		}
	//	@Override
	//	public MemberVO readMember(String id) {
	//		System.out.println("S : readMember()실행");
	//		MemberVO vo = null;
	//		
	//		try {
	//			vo = mdao.readMember(id);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//		
	//		return vo;
	//	}
	
	//회원정보조회
	public memberDTO memberInfo(String id){
		memberDTO dto = null;
		try {
			dto = memberMapper.memberInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	//	public memberDTO memberInfo(String id){
	//			return memberMapper.memberInfo(id);
	//	}
	
	//회원정보수정
	public void updateMember(String id, Model model) {
		model.addAttribute("modifyInfo", memberMapper.memberInfo(id) );
	}
	//회원수정저장
	public int modifySave(memberDTO dto) {
		
//		try {
//			memberMapper.modifySave(dto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	System.out.println("비번 변경 전 : " + dto.getPwd());
	String modifyPwd = pwEncoder.encode(dto.getPwd());
	System.out.println("비번 변경 후 : " + modifyPwd);
	dto.setPwd(modifyPwd); 

	int result = 0;          
	try { //동일 아이디로 가입시 오류나는 것을 예외로 처리
		result = memberMapper.modifySave(dto);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}
	//아이디찾기
	public memberDTO findMemberId(memberDTO dto) {
		  return memberMapper.findMemberId(dto);
	}
	//비번찾기
	public int pwdCheck(memberDTO dto) {
		return memberMapper.pwdCheck(dto);
	}
	public void pwdUpdate(memberDTO dto) {
		System.out.println("비번 변경 전 : " + dto.getPwd());
		String newUpdatePwd = pwEncoder.encode(dto.getPwd());
		System.out.println("비번 변경 후 : " + newUpdatePwd);
		dto.setPwd(newUpdatePwd); 
	    memberMapper.pwdUpdate(dto);
	}
	public void deleteMemberCheck(memberDTO dto) throws Exception{
		memberMapper.deleteMemberCheck(dto);
	}
	    

	//회원목록,페이징
	public void memberInfoList(Model model,int num) {
		int pageLetter = 10;
		int allCount = memberMapper.selectMemberCount();
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) {
			repeat += 1;
		}
		int end = num * pageLetter;
		int start = end + 1 -pageLetter;

		model.addAttribute("repeat", repeat);

		model.addAttribute("memberList", memberMapper.memberInfoList(start, end));
	}

	//회원한명에 대한 정보
	public void detailInfo(Model model, String id) {
		model.addAttribute("detailInfo", memberMapper.userCheck(id));
	}

	//회원삭제
	public void detailInfoDel(String id) {
		memberMapper.detailInfoDel(id);
	}

	//검색
	@Override
	public void searchId(Model model, String userId, int num) {
		int pageLetter = 5;
		int allCount = memberMapper.selectSearchIdCount(userId);
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) {
			repeat += 1;
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;

		model.addAttribute("repeat", repeat);

		model.addAttribute("memberList", memberMapper.searchId(userId, start, end));
	}
}