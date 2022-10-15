package com.care.root.member.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.common.memberLoginSession;
import com.care.root.member.dto.memberDTO;
import com.care.root.member.service.memberService;

@Controller
@RequestMapping("member")
public class memberController implements memberLoginSession{
	@Autowired memberService ms;
	private final memberService members;

	    public memberController(memberService members){
	        this.members = members;
	    }
	
	
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
	//로그아웃시 세션종료후 메인index로 이동
	@GetMapping("logout")
	public String logout(HttpSession session, 
			HttpServletResponse response,
			@CookieValue(value="loginCookie",required=false) Cookie loginCookie) //자동로그아웃(쿠키종료)위해 쿠키 받아오기
	{
		if(session.getAttribute(LOGIN) != null) {
			if(loginCookie != null) {
				loginCookie.setPath("/"); //경로명시를 해야 쿠키종료, 최상위로 잡기
				loginCookie.setMaxAge(0);//쿠키값 0으로 설정
				response.addCookie(loginCookie); //사용자에게 보내기
				ms.keepLogin("nan",new java.sql.Date(System.currentTimeMillis()), //db도 변경(업데이트 keepLogin호출), 들어온 쿠키값은 다시 nan으로 처리//현재시간으로 변경
						(String)session.getAttribute(LOGIN)); //login비교할 아이디
			}
		}
		session.invalidate();           //세션종료                 
		return "redirect:/index";  
	}
	//회원가입 페이지 연결
	@GetMapping("register_form")
	public String register() {
		return "member/register";
	}
	@PostMapping("register")
	public String register(memberDTO dto) {  //dto로 받기
		int result = ms.register(dto);
		if(result==1) {
			return "redirect:login";//성공하면 login 페이지로
		}
		return "redirect:register_form";//실패하면 다시 회원가입 폼으로 이동
	}
	@PostMapping(value="idCheck",produces = "application/json; charset=utf8")
	@ResponseBody
	public Map<Object, Object> idCheck(@RequestBody String id){
		int count=0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		count = ms.idCheck(id);
		map.put("cnt", count);
		return map;
	}

	//마이페이지- 회원정보확인
		@GetMapping("myInfo")
		public String myInfo(HttpSession session, Model model, String id) {
			System.out.println("회원정보 페이지 연결");
			//세션 객체 안에 있는 ID정보 저장
			String memberId = (String) session.getAttribute("memberId");
			System.out.println("getid :  "+memberId);
			//서비스안의 회원정보보기 메서드 호출
			memberDTO dto = ms.memberInfo(memberId);
			//정보저장 후 페이지 이동
			model.addAttribute("info", dto);
			System.out.println("get dto :" +dto);
			return "member/myInfo";
		}
		
//		AccountContext ac = (AccountContext) authentication.getPrincipal();
//	    model.addAttribute("info", ac.getUsername());
//	@GetMapping("myInfo")
//		public String myInfo(Principal principal, ModelMap modelMap){
//	        String loginId = principal.getName();
//	        memberDTO dto = ms.getUserSessionId(loginId);
//	        modelMap.addAttribute("info", dto);
//	        return "member/myInfo";
//	}
	
	
//	@GetMapping("myInfo")
//	public String myInfo(String id, Model model, HttpSession session){
//		model.addAttribute("info", ms.memberInfo(id));
//		return "member/myInfo";
//	}
	
}