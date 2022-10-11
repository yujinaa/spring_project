package com.care.root.booking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.booking.dto.bookingDTO;
import com.care.root.booking.service.bookingService;
import com.care.root.member.common.memberLoginSession;
import com.care.root.member.dto.memberDTO;

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
	public String bookingDo( HttpSession session, bookingDTO bookingDto, RedirectAttributes rs) {
		//memberDTO mDto = (memberDTO)session.getAttribute(LOGIN);
		//bookingDto.setUserId(mDto.getId());
		//		String userId = (String)session.getAttribute(LOGIN);
		//		bookingDto.setUserId(userId);;
		bs.bookingDo(bookingDto);
		rs.addFlashAttribute("msg","넘어가기");
		return "redirect:/index";
	}
	//	String userId = (String)session.getAttribute(LOGIN);

	//	@GetMapping("bookingCheck")
	//	public String bookCheck( @RequestParam(defaultValue = "1") int bookingId,Model model) {
	//		bs.bookCheck(bookingId, model);
	//		System.out.println("bookingId :" + bookingId);
	//		return "booking/bookingCheck";
	//	}

	//마이페이지-내예약정보
	@GetMapping("bookingInfo")
	public String bookingInfo(@RequestParam (value="bookingId",required = false,defaultValue = "1") int bookingId, Model model
						,HttpSession session
						){
		System.out.println("예약정보확인");
		String userId = (String)session.getAttribute(LOGIN);
		bs.info(bookingId,model);
		System.out.println("bookingId :" + bookingId);
		System.out.println("userId :" + userId ) ;
		return "booking/bookingInfo";
	}
}