package com.care.root.member.service;
import java.util.HashMap;

import com.care.root.member.dto.kakaoMemberDTO;

public interface kakaoService {
	public String getToken (String authorize_code);
	public  kakaoMemberDTO getKakaoUserInfo (String access_Token);
}
