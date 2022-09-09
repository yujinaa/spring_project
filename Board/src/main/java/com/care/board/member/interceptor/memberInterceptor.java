package com.care.board.member.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.board.commonSession.loginSessionName;

public class memberInterceptor extends HandlerInterceptorAdapter implements loginSessionName{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(); //세션 얻어오기
		
		if(session.getAttribute(LOGIN)==null) {
//			response.sendRedirect("login"); //세션 없으면 바로 로그인 페이지 띄우기
			response.setContentType("text/html; charset = utf-8"); //세션없으면 alert메시지 띄운후 이동
			PrintWriter out =response.getWriter();
			out.print("<script>alert('로그인 해주세요'); "
					+  "location.href ='"+request.getContextPath() +"/member/login';</script>"); 
			return false; //false는 사용자가 요청한 경로로 가지 않고, true면 사용자가 요청한 경로로 연결
		}
		
		
		System.out.println("index컨트롤러 실행 전 실행");
		return true;
	}

}
