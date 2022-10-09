package com.care.root.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("booking")
public class bookingController {
	@GetMapping("booking")
	public String booking() {
		return "booking/booking";
	}

	@GetMapping("bookingCheck")
	public String bookingCheck() {
		return "booking/bookingCheck";
	}


}
