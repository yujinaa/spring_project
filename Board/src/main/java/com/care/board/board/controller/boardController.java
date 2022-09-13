package com.care.board.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.board.board.service.boardService;
import com.care.board.commonSession.loginSessionName;

@Controller
@RequestMapping("board")
public class boardController implements loginSessionName{	
	@Autowired boardService bs;
	
	@GetMapping("list")
	public String board(HttpSession session, Model model) { //db에 저장된 모든 값 가져오기
		if(session.getAttribute(LOGIN) != null) {
			bs.boardList(model);
			return "board/list";			
		}
		return "member/login";
	}
}
