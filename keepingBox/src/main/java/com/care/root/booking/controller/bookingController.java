package com.care.root.booking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.booking.dto.bookingDTO;
import com.care.root.booking.service.bookingService;
import com.care.root.member.dto.memberDTO;

@Controller
@RequestMapping("booking")
public class bookingController {
	@Autowired bookingService bs;

		//예약페이지 연결
	@GetMapping("booking")
	public String booking() {
		return "booking/booking";
	}
	//예약하기
	@PostMapping("bookingDo")
	public String bookingDo(HttpSession session, bookingDTO bookingDto) {
		bs.bookingDo(bookingDto);
		return "redirect:bookingCheck";
	}
	

//	@GetMapping("bookingCheck")
//	public String bookingCheck() {
//		return "booking/bookingCheck";
//	}
	
	//마이페이지-내예약정보
//	@GetMapping("bookinbInfo")
//	public String bookInfo(@RequestParam String userId, Model model) {
//		bs.info(model, userId);
//		return "member/bookinInfo";
//	}

}

