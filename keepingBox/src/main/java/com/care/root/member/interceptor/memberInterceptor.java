package com.care.root.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.member.common.memberLoginSession;

public class memberInterceptor extends HandlerInterceptorAdapter implements memberLoginSession{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터실행");
		return true;
	}

}
