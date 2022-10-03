package com.care.root.member.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

}
