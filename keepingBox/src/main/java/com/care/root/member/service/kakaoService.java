package com.care.root.member.service;
import java.util.HashMap;

import com.care.root.member.dto.kakaoMemberDTO;

public interface kakaoService {
	public String getToken (String authorize_code);
//	public  HashMap<String, Object> getKakaoUserInfo (String access_Token);
	public  kakaoMemberDTO getKakaoUserInfo (String access_Token);
//	public String KakaoLoginChk(String nickname, String email);
}
