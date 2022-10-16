package com.care.root.member.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
//	public memberDTO memberInfo(String id){
//			return  memberMapper.memberInfo(id);
//		}
	
	public memberDTO memberInfo(String userId){
		memberDTO dto = null;
		try {
			dto = memberMapper.memberInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  dto;
	}
	
	public void memberInfoList(Model model) {
		model.addAttribute("memberList", memberMapper.memberInfoList());
	}
	}