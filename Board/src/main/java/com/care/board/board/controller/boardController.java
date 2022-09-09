package com.care.board.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.board.commonSession.loginSessionName;

@Controller
@RequestMapping("board")
public class boardController implements loginSessionName{	
	
	@GetMapping("list")
	public String board(HttpSession session) {
		if(session.getAttribute(LOGIN) != null) {
			return "board/list";			
		}
		return "member/login";
	}
}
