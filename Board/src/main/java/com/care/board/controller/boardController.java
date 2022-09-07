package com.care.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class boardController {	
	@GetMapping("/list")
	public String board() {
		return "board/list";
	}
}
