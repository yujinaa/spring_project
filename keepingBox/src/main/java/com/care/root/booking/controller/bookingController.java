package com.care.root.booking.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	//결제하기
	@GetMapping("bookingPay")
	@ResponseBody
	public void bookPay(int amount,String imp_uid, String merchant_uid) throws Exception{

		System.out.println("결제 성공");
		System.out.println("결제 금액 : " + amount);
		System.out.println("imp_uid : " + imp_uid);
		System.out.println("merchant_uid : " + merchant_uid);
	}
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

	//관리자 - 예약목록
	@GetMapping("memBookingList")
	public String memBookingList(Model model,@RequestParam(value="id", required=false) String id, 
			HttpSession session,@RequestParam(required = false, defaultValue = "1" ) int num) {
		bs.memBookList(model,num);
		return "booking/memBookingList";
	}
}