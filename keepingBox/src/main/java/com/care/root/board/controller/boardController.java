package com.care.root.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.board.service.boardService;


@Controller
@RequestMapping("board")
public class boardController{
	@Autowired boardService bs;
	
	//이용후기 게시판 목록
	@GetMapping("review")
	public String review(Model model) { //db에 저장된 모든 값 가져오기,값이 없다면 default값으로 1주기) {
		bs.boardList(model);
		//if(session.getAttribute(LOGIN) != null) {
			return "board/review";			
		//}
		//return "board/login";
	}
	
}
