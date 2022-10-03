package com.care.root.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.care.root.member.common.memberLoginSession;
import com.care.root.member.dto.memberDTO;
import com.care.root.member.service.memberService;

//자동로그인도 인터셉터로 구현
public class autoLoginInterceptor extends HandlerInterceptorAdapter 
implements memberLoginSession{
	@Autowired memberService ms;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"); //WebUtils이용해서 쿠키값 한번에 얻어오기
		System.out.println("loginCookie : " + loginCookie);//확인하기
		if(loginCookie != null) { //null과 같지 않다면 서비스쪽으로 연결
			memberDTO dto = ms.getUserSessionId(loginCookie.getValue()); // 결과값은 dto형태로 저장.세션id를 통해 로그인된 id가져오기
			if(dto != null) { //dto값이 null이 아니면 같은 값이 있다는 것이니 세션만들기
				request.getSession().setAttribute(LOGIN, dto.getId());
			}
		}
		return true;
	}
}
