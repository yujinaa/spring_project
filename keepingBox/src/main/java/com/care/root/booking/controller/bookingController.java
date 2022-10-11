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
		return "redirect:bookingCheck";
	}
//	String userId = (String)session.getAttribute(LOGIN);

	@GetMapping("bookingCheck")
	public String bookingCheck() {
		return "booking/bookingCheck";
	}
	
	//마이페이지-내예약정보
	@GetMapping("bookingInfo")
	public String bookingInfo() {//@RequestParam String userId, Model model
		//bs.info(model, userId);
		return "booking/bookingInfo";
	}

}

