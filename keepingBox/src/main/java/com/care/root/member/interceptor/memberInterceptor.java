package com.care.root.member.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.member.common.memberLoginSession;

public class memberInterceptor extends HandlerInterceptorAdapter implements memberLoginSession{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(); //세션 얻어오기

		if(session.getAttribute(LOGIN) == null) {//여기서 미리 작성
			//response.sendRedirect("login");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 후 이용가능합니다.'); "
					+ "location.href ='"+request.getContextPath() +"/member/login';</script>"); 
			return false;  //해당 redirect
		}
		System.out.println("인터셉터실행");
		return true;  //해당 사용자가 요청한 경로가 들어간다. 인터셉터가 끝나면 멤버컨트롤러가 실행
	}
}
