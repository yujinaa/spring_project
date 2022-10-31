package com.care.root.booking.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.care.root.booking.dto.bookingDTO;
import com.care.root.booking.service.bookingService;
import com.care.root.member.common.memberLoginSession;

@Controller
@RequestMapping("booking")
public class bookingController implements memberLoginSession{
	@Autowired bookingService bs;

	//예약페이지 연결
	@GetMapping("booking")
	public String booking() {
		return "booking/booking";
	}
	//예약하기
	@PostMapping("bookingDo")
	public String bookingDo( HttpSession session, bookingDTO bookingDto) {
		//memberDTO mDto = (memberDTO)session.getAttribute(LOGIN);
		//bookingDto.setUserId(mDto.getId());
		//		String userId = (String)session.getAttribute(LOGIN);
		//		bookingDto.setUserId(userId);;
		bs.bookingDo(bookingDto);
		return "redirect:bookingInfo";
	}
	//	@GetMapping("bookingCheck")
	//	public String bookingCheck(@RequestParam int bookingId,Model model)throws Exception {
	//		System.out.println("확인페이지");
	//		bs.bookChkList(bookingId,model);
	//		return "booking/bookingCheck";
	//	}


	//예약내역
	@GetMapping("bookingInfo")
	public String bookingCheck(HttpSession session, Model model)throws Exception {
		String userId = (String) session.getAttribute(LOGIN);
		System.out.println("getid :  "+userId);
		model.addAttribute("booking", bs.bookingInfo(userId));
		return "booking/bookingInfo";
	}

	//예약삭제
	@GetMapping("bookDelete")
	public String bookDelete(int bookingId){
		bs.bookDelete(bookingId);
		return "redirect:bookingInfo";
	}


	//	String userId = (String)session.getAttribute(LOGIN);

	//	@GetMapping("bookingCheck")
	//	public String bookCheck( @RequestParam(defaultValue = "1") int bookingId,Model model) {
	//		bs.bookCheck(bookingId, model);
	//		System.out.println("bookingId :" + bookingId);
	//		return "booking/bookingCheck";
	//	}


	//	//세션 객체 안에 있는 ID정보 저장
	//		String id = (String) session.getAttribute("id");
	//		l.info("C: 회원정보보기 GET의 아이디 "+id);
	//
	//		//서비스안의 회원정보보기 메서드 호출
	//		MemberVO vo = service.readMember(id);
	//
	//		//정보저장 후 페이지 이동
	//		model.addAttribute("memVO", vo);
	//		l.info("C: 회원정보보기 GET의 VO "+ vo);
}