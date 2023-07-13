package com.care.root.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.kakaoMemberDTO;
import com.care.root.mybatis.member.memberMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class kakaoLoginService implements kakaoService{
	@Autowired memberMapper memberMapper; //매퍼 연결하기

	//토큰값 받기위해 전송
	public String getToken (String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			//POST 요청을 위해 기본값이 false인 setDoOutput을 true로 해야한다.
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			//POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=6cfbb25d1642a05ea21e31ecb13db43c");  //본인이 발급받은 key
			sb.append("&redirect_uri=http://localhost:8084/root/member/kakaoCallback");     // 본인이 설정해 놓은 경로
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			//결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			//요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}

	//	카카오 사용자 정보 가져와서 db저장
	public kakaoMemberDTO getKakaoUserInfo (String access_Token){

		kakaoMemberDTO userInfo = new kakaoMemberDTO();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			//    요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();

			userInfo.setNickName(nickname);
			userInfo.setEmail(email);

		} catch (IOException e) {
			e.printStackTrace();
		}
		kakaoMemberDTO result = memberMapper.findKakao(userInfo);
		System.out.println("저장값 : " + result);

		if(result ==null) {
			//result null 이면 정보가 저장 안되어있는거라서 저보를 저장.
			memberMapper.kakaoInsert(userInfo);
			//저장하기위해 repository 로 이동
			return memberMapper.findKakao(userInfo);
			// 정보 저장후 컨트롤러에 정보를 보냄
			//result 를 리턴으로 보내면 null 이 리턴되므로 위코드를 사용.
		}else {
			return result;
			//정보가 있으므로 result 를 리턴함
		}
	}
}
