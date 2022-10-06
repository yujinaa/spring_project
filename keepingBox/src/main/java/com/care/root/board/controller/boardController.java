package com.care.root.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.board.dto.boardDTO;
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
	@PostMapping("writeSave")
	public String writeSave(boardDTO dto, RedirectAttributes rs) {                   
			
			System.out.println("저장하기 실행");
			bs.writeSave(dto);
			rs.addFlashAttribute("result", "success");		
			return "redirect:review";
	}
	@GetMapping("reviewDetail")
	public String reviewDetail(@RequestParam int reviewNum, Model model) {
		bs.reviewDetail(reviewNum, model);
		return "board/reviewDetail";
	}

}
