package com.care.root.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.Format;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.board.dto.noticeDTO;
import com.care.root.member.dto.memberDTO;
import com.care.root.mybatis.member.memberMapper;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class memberServiceImpl implements memberService {
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
	public memberDTO memberInfo(String id){
		memberDTO dto = null;
		try {
			dto = memberMapper.memberInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}


	//회원정보수정
	public void updateMember(String id, Model model) {
		model.addAttribute("modifyInfo", memberMapper.memberInfo(id) );
	}
	//회원수정저장
	public int modifySave(memberDTO dto) {


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

	//	public boolean pwdCheck(String id, String pwd) {
	//		// 회원 정보 수정 및 삭제를 위한 비밀번호 체크
	//		boolean result = false;
	//		Map<String, String> map = new HashMap<String, String>();
	//		map.put("delId", id);
	//		map.put("pwd", pwd);
	//		int count = memberMapper.pwdCheck(id, pwd);
	//	}
	public void deleteMemberCheck(memberDTO dto) {
		//회원탈퇴를 잘 수행하는 지 dao의 deleteSecession 메서드로 go
		memberMapper.deleteMemberCheck(dto);
	}
	//	public int delCheck(memberDTO dto, String inputPwd) {
	//		try {
	//			if(pwEncoder.matches(inputPwd, dto.getPwd())) {
	//			memberMapper.delCheck(dto);
	//			return 0;
	//		}}catch (Exception e) {
	//						e.printStackTrace();
	//		}
	//		return 1;
	//	}
	//	public void deleteMemberCheck(memberDTO dto){
	////		String oldPwd = dto.getPwd();
	//		try {
	////			if(pwEncoder.matches(oldPwd, dto.getPwd())){
	//			memberMapper.deleteMemberCheck(dto);
	////			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}


	//		public boolean check(String id, String pwd) {
	//			return memberMapper.check(id,pwd);
	//		}
	//		}    
	//	public int deleteMemberCheck(HttpSession session, String pwd) {
	//		memberDTO dto= memberMapper.deleteMemberCheck(session);
	//		if(dto != null) {
	//			if(pwd.equals(dto.getPwd())) {
	//				return 0;
	//			}
	//		}
	//return 1;
	//	}

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