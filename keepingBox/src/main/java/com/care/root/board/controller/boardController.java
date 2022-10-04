package com.care.root.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	//글쓰기
	@GetMapping("reviewWrite")
	public String reviewWrite() {
		return "board/reviewWrite";
	}
	//글저장하기
//	@PostMapping("writeSave")
//	public void writeSave(HttpServletResponse response,  //out 객체를 만들어 사용자에게 전달
//			HttpServletRequest request) throws IOException{                    //request는 경로 설정
//		System.out.println("저장하기 실행");
//		String message =bs.writeSave(request);//request는 세션이나 절대경로
//		PrintWriter out= null;
//		response.setContentType("text/html; charset = utf-8");
//		out = response.getWriter();
//		out.println(message);
//	}

}
