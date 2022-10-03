package com.care.root.member.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.common.memberLoginSession;
import com.care.root.member.service.memberService;

@Controller
@RequestMapping("member")
public class memberController implements memberLoginSession{
	@Autowired memberService ms;
	//로그인클릭
	@GetMapping("login")
	public String login() {
		System.out.println("로그인페이지이동");
		return "member/login";
	}
	//로그인시 확인
	@PostMapping("user_check")
	public String userCheck(@RequestParam  String id, @RequestParam  String pwd,
							@RequestParam(required = false) String autoLogin, //자동로그인
							RedirectAttributes rs) {  //id, pwd 받아줄것
		int result = ms.userCheck(id,pwd); //서비스로 id,pwd넘기기
		System.out.println("result : " +result); //result확인
				System.out.println("autoLogin : " + autoLogin);

		//result=0이면 성공(rs로 id, autoLogin넘기기)
		if(result == 0) {
			rs.addAttribute("id",id);
			rs.addAttribute("autoLogin",autoLogin);
			return "redirect:successCheckLogin"; //바로 로그인성공페이지
		}else { //로그인 체크 실패시
			return "redirect:login"; //다시 로그인페이지로
		}
	}
	//로그인 성공후 메인페이지인 index로 이동
	@GetMapping("successCheckLogin")
	public String successCheckLogin(@RequestParam String id, 
			@RequestParam(required = false) String autoLogin,
			HttpSession session, HttpServletResponse response) { //로그인 사용자라면 쿠키 응답하기
		System.out.println("id : " + id);
		System.out.println("autoLogin : " + autoLogin);
		session.setAttribute(LOGIN, id);

		//쿠키
		if(autoLogin != null) {//자동로그인에 체크한 사용자라면 설정값만큼 사용자가 쿠키값 갖고있기
			int limitTime = 60*60*24*90; //시간설정 90일
			Cookie loginCookie = new Cookie("loginCookie", session.getId()); //유일한 값으로 저장
			loginCookie.setPath("/"); //경로는 최상위로 잡기
			loginCookie.setMaxAge(limitTime);
			response.addCookie(loginCookie);

			//캘린더 
			Calendar calD = Calendar.getInstance();	//캘린더 형태로 시간변환
			calD.setTime(new Date());                //util에 있는 현재 시간 date
			calD.add(Calendar.MONTH,3);            //현재시간에서 3개월 후 시간설정

			java.sql.Date limitDate = new java.sql.Date(calD.getTimeInMillis()); //현재 시간을 sql로 변환.시간설정
			ms.keepLogin(session.getId(), limitDate, id);  //db에 저장하기 위해 ms로 메소드 만들기
		}

		return "index";
	}

}
