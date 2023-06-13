package com.care.root.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.care.root.member.common.memberLoginSession;
import com.care.root.member.dto.kakaoMemberDTO;
import com.care.root.member.dto.memberDTO;
import com.care.root.member.service.kakaoLoginService;
import com.care.root.member.service.memberService;

@Controller
@RequestMapping("member")
public class memberController implements memberLoginSession{
	@Autowired memberService ms;
	@Autowired kakaoLoginService kakao;
	BCryptPasswordEncoder pwEncoder; //암호화

	public memberController() {
		pwEncoder = new BCryptPasswordEncoder();

	}

	//로그인클릭
	@GetMapping("login")
	public String login() {
		System.out.println("로그인페이지이동");
		return "member/login";
	}

	//카카오 로그인
	@GetMapping("kakaoCallback")
	public String kakaoLogin(@RequestParam String code,HttpSession session)  throws IOException{
		System.out.println("코드 : " +code);

		String access_Token = kakao.getToken(code);
		//		HashMap<String, Object> userInfo = kakao.getKakaoUserInfo(access_Token);

		kakaoMemberDTO userInfo = kakao.getKakaoUserInfo(access_Token);

		if (userInfo.getEmail() != null) {

			session.setAttribute("email", userInfo.getEmail());
			session.setAttribute("nickName", userInfo.getNickName());
			session.setAttribute("access_Token", access_Token);

			System.out.println("**access_Token : " + access_Token);
			System.out.println("**nickname : " + userInfo.getNickName());
			System.out.println("**email : " + userInfo.getEmail());



		}
		return "index";
		//		return "redirect:login";
	}
	//	@GetMapping("kakaoLogin")
	//	public String kakaoLogin(@RequestParam String email,
	//			HttpSession session, HttpServletResponse response) { //로그인 사용자라면 쿠키 응답하기
	//		System.out.println("email : " + email);
	//		session.setAttribute(KAKAOLOGIN, email);
	//
	//		return "index";
	//	}

	//	@GetMapping("successKakaoLogin")
	//	public String successKakaoLogin(@RequestParam String email,
	//			HttpSession session) { //로그인 사용자라면 쿠키 응답하기
	//		session.getAttribute(KAKAOLOGIN);
	//		System.out.println("카카오 로그인 성공 email : " +email);
	//		return "index";
	//	}
	//	@GetMapping("successKakaoLogin")
	//	public String successKakaoLogin(HttpSession session, HttpServletResponse response) {	
	//		kakaoMemberDTO userInfo = kakao.getKakaoUserInfo("email");
	//		String email = kakao.KakaoLoginChk(userInfo.getNickName().toString(), userInfo.getEmail().toString());
	//		
	//		if(!email.equals("0")){
	//			session.setAttribute(LOGIN, email);
	//			session.setAttribute(KAKAOLOGIN, email);
	//			//System.out.println("일반 세션명 : " + session.getAttribute(LOGIN));
	//			//System.out.println("카카오 세션명 : " +  session.getAttribute(KAKAOLOGIN));
	//			System.out.println("카카오 로그인성공");
	//			return email;
	//		}
	//		else {
	////			int result = ms.KakaoRegister(userInfo.get("id").toString(), kakao_info.get("email").toString());
	////			if(result == 1) {
	////				if(session.getAttribute( KAKAOLOGIN ) == null) {
	////					session.setAttribute(KAKAOLOGIN, kakao_info.get("email").toString());
	////				}
	////				System.out.println("가입성공 : " + kakao_info.get("email").toString());
	////				return kakao_info.get("email").toString();
	////			}else {
	//				System.out.println("문제발생");
	//				return "login";
	//			}
	//		}
	//		
	//	
	//	

	//로그인시 확인
	@PostMapping("user_check")
	public String userCheck(@RequestParam  String id, @RequestParam  String pwd,
			@RequestParam(required = false) String autoLogin, //자동로그인
			RedirectAttributes rs, HttpServletResponse response) throws IOException {  //id, pwd 받아줄것
		int result = ms.userCheck(id,pwd); //서비스로 id,pwd넘기기
		System.out.println("result : " +result); //result확인
		System.out.println("autoLogin : " + autoLogin);
		//result=0이면 성공(rs로 id, autoLogin넘기기)
		if(result == 0) {
			rs.addAttribute("id",id);
			rs.addAttribute("autoLogin",autoLogin);
			return "redirect:successCheckLogin"; //+바로 로그인성공페이지
		}else { //로그인 체크 실패시
			PrintWriter out = response.getWriter(); //js가 아니라 controller에서 HttpServletResponse이용해 바로 alert창 띄우기
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			out.println("<script> alert('아이디 또는 비밀번호가 틀립니다.');");
			out.println("history.go(-1); </script>"); //이렇게해야 로그인 페이지로 다시 로드
			out.close();
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
	//내가 쓴 글
	@GetMapping("myReview")
	public String myReview(HttpSession session, Model model)throws Exception {
		System.out.println("내가 쓴글 페이지 연결");
		//세션 객체 안에 있는 ID정보 저장
		String id = (String) session.getAttribute(LOGIN);
		System.out.println("getid :  "+id);

		memberDTO userInfo = ms.getInfo(id);
		model.addAttribute("myInfo", userInfo);
		return "member/myReview";
	}

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
	@PostMapping("findPwdResult")
	public String findPwdCheck(HttpServletRequest request, Model model,
			@RequestParam (required = true, value = "id")String id, @RequestParam(required = true, value = "name") String name,@RequestParam (required = true, value = "email")String email, 
			memberDTO dto) throws IOException {
		try {
			dto.setId(id);
			dto.setName(name);
			dto.setEmail(email);

			int search = ms.pwdCheck(dto);
			if(search == 0) {
				request.setAttribute("msg", "가입된 정보가 없습니다. 다시 입력해주세요.");
				request.setAttribute("url", "findPwd");
				return "alert";
			}
			String newPwd = RandomStringUtils.randomAlphanumeric(10);
			String enpassword = pwEncoder.encode(newPwd); //발급된 임시 비밀번호 암호화시켜 db저장
			dto.setPwd(enpassword );
			ms.pwdUpdate(dto);
			model.addAttribute("newPwd", newPwd);
			System.out.println("새로운 비번 발급 : " + enpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/findPwdResult";
	}
	@GetMapping("findPwdResult")
	public String findPwResult() {
		return "member/findPwdResult";
	}
	//회원탈퇴
	@GetMapping("deleteMember")
	public String deleteMember() {
		return "member/deleteMember";
	}
	@PostMapping("deleteMemberCheck")
	public String deleteMemberCheck(RedirectAttributes ra,@RequestParam("id") String id,  memberDTO dto ,HttpSession session , Model model) {
		//		String d = (String)session.getAttribute(LOGIN)
		//		String id =((memberDTO)(session.getAttribute(LOGIN))).getId();
		//		String id =String.valueOf((memberDTO)(session.getAttribute(LOGIN)));
//				String userId =(String)session.getAttribute(LOGIN);

		int result = ms.deleteMemberCheck(id); 
		if(result==1) {
//			ms.deleteMemberCheck(dto);
			ra.addFlashAttribute("msg", "success");
			session.removeAttribute(LOGIN);
			session.invalidate(); //탈퇴시 로그아웃 처리
			return "redirect:/index";
		}else {
			ra.addFlashAttribute("msg", "fail");
			return "redirect:deleteMember";
		}
	}
	
	

	//	@PostMapping("deleteMemberCheck")
	//	public String deleteMemberCheck( memberDTO dto,HttpSession session , Model model)throws Exception {
	//
	//		
	//	}
	//	@PostMapping("deleteMemberCheck")
	//	public String deleteMemberCheck(  @RequestParam String id,@RequestParam String pwd,HttpSession session , Model model)throws Exception {
	//		//		String d = (String)session.getAttribute(LOGIN)
	////		String id =((memberDTO)(session.getAttribute(LOGIN))).getId();
	////		String id =String.valueOf((memberDTO)(session.getAttribute(LOGIN)));
	////		String id =(String)session.getAttribute(LOGIN);
	//
	//		boolean result = ms.checkPwd(id,pwd); 
	//		System.out.println("delmem :" +id);
	//		System.out.println("delmem :" +pwd);
	//
	//		if(result) {
	//			ms.deleteMemberCheck(id);
	//				session.invalidate(); //탈퇴시 로그아웃 처리
	//			return "redirect:/index";
	//		}else {
	//			//			model.addAttribute("info", ms.memberInfo((String)session.getAttribute(LOGIN)));
	//			return "redirect:deleteMember";
	//		}
	//	}
//	@PostMapping("deleteMemberCheck")
//	public String deleteMemberCheck(  memberDTO dto ,HttpSession session , Model model) {
//		//		String d = (String)session.getAttribute(LOGIN)
//		//		String id =((memberDTO)(session.getAttribute(LOGIN))).getId();
//		//		String id =String.valueOf((memberDTO)(session.getAttribute(LOGIN)));
//				String id =(String)session.getAttribute(LOGIN);
//
//		int result = ms.checkPwd(id,dto.getPwd()); 
//		if(result==1) {
//			ms.deleteMemberCheck(dto);
//
//			String object = (String) session.getAttribute(LOGIN);
//
//			if(object != id) {
//				session.removeAttribute(LOGIN);
//				session.invalidate(); //탈퇴시 로그아웃 처리
//			}
//			return "redirect:/index";
//		}else {
//
//			return "redirect:deleteMember";
//		}
//	}

//			@PostMapping("deleteMemberCheck")
//			public String deleteMemberCheck(RedirectAttributes rttr,memberDTO dto, HttpSession session )throws Exception {
		
	//	//		String delId = (String) session.getAttribute(LOGIN);
	//	//		System.out.println("delmem :" +id);
	//			String id =((memberDTO)(session.getAttribute(LOGIN))).getId();
	//			 memberDTO member = (memberDTO)session.getAttribute(LOGIN);
	//			 String id = session.getId();
	//			String oldPass = member.getPwd();
	//			String newPass = dto.getPwd();
	//	
	//	
	//			if(!(oldPass.equals(newPass))) {
	//				rttr.addFlashAttribute("msg", false);
	//				return "redirect:deleteMember";
	//			}else {
	//	
	//				 ms.deleteMemberCheck(id); 
	//				session.invalidate();
	//				return "redirect:/index";
	//			}
	//		}

	//				String inputPwd = memId.getPwd();
	//				String pwdCheck = dto.getPwd();


	//		String id = (String) session.getAttribute(LOGIN);
	//		ms.deleteMemberCheck(id);
	//		session.invalidate();
	//		SecurityContextHolder.clearContext();
	//		return "redirect:/index";

	//		if(!(inputPwd.equals(pwdCheck))) {
	//			return "redirect:deleteMember";
	//		}
	//		ms.deleteMemberCheck(memId);
	//		session.invalidate();
	//

	//		String delId = (String) session.getAttribute(LOGIN);
	//		String delId = ((memberDTO)(session.getAttribute(LOGIN))).getId();
	//	System.out.println("delId : " +delId);

	//		int result = ms.checkPwd(delId,pwd);


	//	if(result==0) {
	//		ms.deleteMemberCheck(delId);
	//		session.invalidate();

	//		boolean result = ms.checkPwd(id, pwd);
	//		String delId = (String) session.getAttribute(LOGIN);
	//		
	//		
	//		memberDTO user = ms.getInfo(delId);
	//		int result = ms.deleteMemberCheck(user);
	//		if(result==0) {
	//			user.getPwd();
	//			session.invalidate();
	//			return "redirect:/index";
	//		} else {
	////			model.addAttribute("message","비밀번호 불일치");
	//			return "redirect:deleteMember";
	//		}
	//			String result = checkPwd(dto.getPwd(),session);
	//			if(result.equals("ok")) {
	//				ms.deleteMemberCheck(dto);
	//				Object object = session.getAttribute(LOGIN);
	//				if(object != null) {
	//					session.invalidate();
	//				}
	//				result = "ok";
	//			}else {
	//				result = "fail";
	//			}
	//			return result;


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
}