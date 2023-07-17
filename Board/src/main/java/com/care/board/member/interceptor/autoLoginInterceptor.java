package com.care.board.member.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.board.commonSession.loginSessionName;

public class autoLoginInterceptor extends HandlerInterceptorAdapter implements loginSessionName {

	//	@Override
	//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	//			throws Exception {
	////		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"); //사용자로부터(request) "loginCookie" 쿠키값 있으면 가져와라
	////		System.out.println("loginCookie : " + loginCookie);
	////		return true;
	////	}

}
