package com.care.root.member.controller;

import java.io.Console;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import jdk.internal.org.jline.utils.Log;
import oracle.jdbc.proxy.annotation.Post;

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
	public String myInfo(HttpSession session, Model model)throws Exception {
		System.out.println("회원정보 페이지 연결");
		//세션 객체 안에 있는 ID정보 저장
		String id = (String) session.getAttribute(LOGIN);
		System.out.println("getid :  "+id);
		//서비스안의 회원정보보기 메서드 호출
		//정보저장 후 페이지 이동
		//		model.addAttribute("info", dto);
		model.addAttribute("info", ms.memberInfo(id));
		//		System.out.println("get dto :" +dto);
		return "member/myInfo";
	}

	//		@GetMapping("myInfo")
	//		public String myInfo( Model model, HttpSession session){
	//			model.addAttribute("info", ms.memberInfo(LOGIN));
	//			System.out.println("id :" + LOGIN);
	//			return "member/myInfo";
	//		}


	//	@GetMapping("myInfo")
	//	public String myInfo(String id, Model model, HttpSession session){
	//		model.addAttribute("info", ms.memberInfo(id));
	//		System.out.println("id :" + id);
	//		return "member/myInfo";
	//	}

	//	@GetMapping("myInfo")
	//	public String myInfo(@RequestParam(value="id", required=false)  String id, Model model, HttpSession session){
	////		  model.addAttribute("info", ms.memberInfo(id));
	//		  System.out.println("클릭한 아이디 : "+id);
	//		ms.memberInfo(model,id);
	//		return "member/myInfo";
	//	}
	//	@GetMapping("myInfo")
	//	public String myInfo(HttpSession session, Model model) {
	//		String id = (String) session.getAttribute(LOGIN);
	//		System.out.println("getid :  "+id);
	//		memberDTO dto = ms.memberInfo(id);
	//		if (id != null) {
	//		model.addAttribute("info",dto);
	//		}
	//		return "member/myInfo";
	//      }
	//회원정보수정페이지 연결
	@GetMapping("myInfoModify")
	public String myInfoModify(HttpSession session, Model model) {
		model.addAttribute("info", ms.memberInfo((String)session.getAttribute(LOGIN))); //마이페이지와 같은 코드이고 한줄로 줄임
		return "member/myInfoModify";
	}
	//수정하기 저장
	@PostMapping("modifySave")
	public String modify(memberDTO dto){
		int result = ms.modifySave(dto);
		if(result==1) {
			return "redirect:myInfo";
		}
		return "redirect:myInfoModify";
	}

	//아이디찾기페이지연결
	@GetMapping("findId")
	public String findId() {
		System.out.println("아이디찾기페이지 연결");
		return "member/findId";
	}
	//아이디찾기
	@PostMapping("findIdCheck")
	public String searchId(HttpServletRequest request, Model model,memberDTO dto,
			@RequestParam String name, 
			@RequestParam String email) {
		try {
			dto.setName(name);
			dto.setEmail(email);
			memberDTO id = ms.findMemberId(dto);

			model.addAttribute("findId", id);

		} catch (Exception e) {
			model.addAttribute("msg", "오류가 발생되었습니다.");
			e.printStackTrace();
		}
		return "member/findIdResult";
	}
	@GetMapping("findIdResult")
	public String findIdResult() {
		return "member/findIdResult";
	}

	//비번찾기페이지연결
	@GetMapping("findPwd")
	public String searchPwd() {
		return "member/findPwd";
	}
	//비번찾기
	@PostMapping("findPwdCheck")
	public String findPwdCheck(HttpServletRequest request, Model model,
			@RequestParam String id, @RequestParam String name,@RequestParam String email, 
			memberDTO dto) {
		try {
			dto.setId(id);
			dto.setName(name);
			dto.setEmail(email);
			int search = ms.pwdCheck(dto);

			if(search == 0) {
				model.addAttribute("msg", "기입된 정보가 잘못되었습니다. 다시 입력해주세요.");
				return "member/findPwdCheck";
			}

			String newPwd = RandomStringUtils.randomAlphanumeric(10);
			//			String enpassword = encryptPassword(newPwd);
			//			dto.setPwd(enpassword);
			dto.setPwd(newPwd);

			ms.pwdUpdate(dto);

			model.addAttribute("newPwd", newPwd);

		} catch (Exception e) {
			model.addAttribute("msg", "오류가 발생되었습니다.");
			e.printStackTrace();
		}
		return "member/findPwdResult";
	}
	@GetMapping("findPwdResult")
	public String findPwResult() {
		return "member/findPwdResult";
	}
	//회원탈퇴페이지
	@GetMapping("deleteMember")
	public String deleteMember() {
		return "member/deleteMember";
	}
	//회원탈퇴
	//	@PostMapping("deleteMemberCheck")
	//	public String deleteMembeCheck(@RequestParam String pwd, Model model, HttpSession  session) {
	//		String delId = ((memberDTO)session.getAttribute("delId")).getId();
	//		//비번체크
	//		boolean result = ms.pwdCheck(delId,pwd);
	//		if(result) {
	//			ms.deleteMemberCheck(delId);
	//			if(result) {
	//				session.invalidate();
	//			}
	//		return "redirect:/index";
	//	}else {
	//		return "member/deleteMember";
	//	}

	//}

	//	@PostMapping("deleteMemberCheck")
	//	public String deleteMemberCheck(String pwd, HttpSession session){
	//		String id = (String) session.getAttribute("id");
	//		memberDTO dto = ms.getUserSessionId(id);
	//		if(!(pwd.equals(dto.getPwd()))) {
	//			return "redirect:member/deleteMember";
	//		} 
	//		ms.deleteMemberCheck(id);
	//		session.invalidate();
	//		return "redirect:/index";
	//	}
	@PostMapping("deleteMemberCheck")
	public String deleteMemberCheck(String email, HttpSession session, memberDTO dto, Model model){
		if(email.equals(dto.getEmail())) {
			ms.deleteMemberCheck(dto);
			session.invalidate();
			return "redirect:/index";
		} else {
			return "redirect:deleteMember";
		}
	}
//	@ResponseBody
//	@PostMapping("delCheck")
//	public int delCheck(memberDTO dto){
//		int result = ms.delCheck(dto);
//		return result;
//	}
	//	@PostMapping("deleteMemberCheck")
	//	public String deleteMemberCheck(@RequestParam String pwd, Model model, HttpSession session, memberDTO dto){
	//		String id = ((memberDTO)(session.getAttribute("id"))).getId();
	//		// 비밀번호 체크
	//		boolean result = ms.checkPwd(id, pwd);
	//		if(result){ // 비밀번호가 맞다면 삭제 처리
	//			ms.delete(id);
	//			if (result) {
	//				session.invalidate(); //탈퇴시 로그아웃 처리
	//			}
	//			return "redirect:/index";
	//		} else { // 비밀번호가 일치하지 않는다면
	//			return "member/deleteMember";
	//		}
	//	}
	//관리자 - 회원목록
	@GetMapping("memberList")
	public String memberList(Model model,@RequestParam(value="id", required=false) String id, 
			HttpSession session,@RequestParam(required = false, defaultValue = "1" ) int num) {
		if(id != null) {
			ms.searchId(model, id, num);
		}else {
			ms.memberInfoList(model,num);
		}
		return "member/memberList";
	}
	//관리자 - 회원상세정보
	@GetMapping("memberListDetail")
	public String memberDetail(@RequestParam String id, Model model) {
		ms.detailInfo(model, id);
		return "member/memberListDetail";
	}

	//관리자 -회원삭제
	@GetMapping("detailInfoDel")
	public String detailInfoDel(memberDTO dto, RedirectAttributes rs){
		ms.detailInfoDel(dto.getId());
		rs.addFlashAttribute("result","detailInfoDelsuccess");
		return "redirect:memberList";
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



}