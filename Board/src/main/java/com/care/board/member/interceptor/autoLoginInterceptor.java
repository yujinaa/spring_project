package com.care.board.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

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
