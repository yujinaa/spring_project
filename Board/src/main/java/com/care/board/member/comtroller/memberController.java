package com.care.board.member.comtroller;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.board.commonSession.loginSessionName;
import com.care.board.member.dto.memberDTO;
import com.care.board.member.service.memberService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("member")
public class memberController implements loginSessionName{
	@Autowired memberService ms;
	@GetMapping("login")
	public String login() {
		System.out.println("로그인 연결");
		return "member/login";
	}
	
	//로그인 체크
	@PostMapping("user_check")   
	public String userCheck(@RequestParam String userId, @RequestParam String userPwd, @RequestParam(required = false) String autoLogin, RedirectAttributes rs) {
		int result = ms.userCheck(userId,userPwd);
		System.out.println("autoLogin : " + autoLogin );
		if(result==0) { //성공
			rs.addAttribute("userId", userId); //controller까지만 연결하기위해 model사용, jsp까지 보내려면 redirectAttributes
			rs.addAttribute("autoLogin", autoLogin);
			return "redirect:loginSuccess";
		}else {//실패
			return "redirect:login";
		}
		}
	
	//로그인 성공시 이동 페이지
	@GetMapping("loginSuccess")
	public String loginSuccess(@RequestParam String userId, @RequestParam(required = false) String autoLogin,
							HttpSession session, HttpServletResponse response) {//세션, response로 쿠키 전달
		System.out.println("id : " + userId);
		System.out.println("autoLogin : " + autoLogin);
		session.setAttribute(LOGIN, userId);
		if(autoLogin != null) {  //자동로그인이 체크되있다면
			int limitTime = 60*60*24*90; //90일
			Cookie loginCookie = new Cookie("loginCookie", session.getId());//세션으로 id가져오기
			loginCookie.setPath("/");
			loginCookie.setMaxAge(limitTime);
			response.addCookie(loginCookie);
			
			//db에 시간설정(캘린더이용)
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());//util에 있는 현재 시간 얻어와서 캘린더 형태로 변환
			cal.add(Calendar.MONTH, 3); //현재 시간에서 3개월 후로 설정
			
			//현재 시간을 sql형태로 변환하기
			java.sql.Date limitDate = new java.sql.Date(cal.getTimeInMillis());
			ms.keepLogin(session.getId(), limitDate, userId);
		}
		return "index";
	
}
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response,
							@CookieValue(value="loginCookie", required = false)Cookie loginCookie) {//로그아웃시 쿠키있음 만료
		if(session.getAttribute(LOGIN)!=null) //세션이 있으면
			if(loginCookie != null) {
				loginCookie.setMaxAge(0); //시간 0으로 설정
				response.addCookie(loginCookie); //사용자에게 보내기
				ms.keepLogin("nan", new java.sql.Date(System.currentTimeMillis()) ,(String)session.getAttribute(LOGIN)); //쿠키값 다시 nan으로바꾸고, 시간, 비교아이디
			}
			session.invalidate(); //세션 종료
		System.out.println("로그아웃성공");
		return "redirect:/index";
	}
	//회원가입 페이지이동
	@GetMapping("signUp")
	public String signUp() {
		return "member/signUp";
	}
	//회원가입
	@PostMapping("signUp")
	public String signUp(memberDTO dto) {
		int result = ms.signUp(dto);
		if(result==1) {
			//회원가입 성공
			return "redirect:login";
		}else {
			return "redirect:signUp";
		}
	}
}

//	@PostMapping("user_check")
//	public String userCheck(@RequestParam String userId, @RequestParam String userPwd, RedirectAttributes rs) {
//		int result = ms.userCheck(userId,userPwd);
//		if(result==0) { //성공
//			rs.addAttribute("userId", userId); //controller까지만 연결하기위해 model사용, jsp까지 보내려면 redirectAttributes
//			return "redirect:successLogin";
//		}else {//실패
//			return "redirect:login";
//		}
//		}
	
//	@GetMapping("successLogin")
//	public String index(@RequestParam String userId, HttpSession session) {
//		session.setAttribute("userId", userId);
//		return "member/successLogin";
//	}
//	}