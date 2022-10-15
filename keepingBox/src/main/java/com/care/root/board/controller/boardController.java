package com.care.root.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.board.dto.boardDTO;
import com.care.root.board.dto.noticeDTO;
import com.care.root.board.service.boardService;
import com.care.root.member.common.memberLoginSession;


@Controller
@RequestMapping("board")
public class boardController implements memberLoginSession{
	@Autowired boardService bs;

	//이용후기 게시판 목록
	@GetMapping("review")
	public String review(Model model,@RequestParam(required = false, defaultValue = "1")int num) { //db에 저장된 모든 값 가져오기,값이 없다면 default값으로 1주기) {
		bs.boardList(model,num);
		//if(session.getAttribute(LOGIN) != null) {
		return "board/review";			
		//}
		//return "board/login";
	}
	//글쓰기
	@GetMapping("reviewWrite")
	public String reviewWrite(HttpSession session) {
		return "board/reviewWrite";
	}
	//글저장하기
	@PostMapping("writeSave")
	public String writeSave(boardDTO dto, RedirectAttributes rs) {                   

		System.out.println("저장하기 실행");
		bs.writeSave(dto);
		rs.addFlashAttribute("result", "savesuccess");		
		return "redirect:review";
	}
	//글 상세보기
	@GetMapping("reviewDetail")
	public String reviewDetail(@RequestParam int reviewNum, Model model) {
		bs.reviewDetail(reviewNum, model);
		return "board/reviewDetail";
	}
	//삭제
	@GetMapping("delete")
	public String delete(int reviewNum, RedirectAttributes rs){
		bs.delete(reviewNum);
		rs.addFlashAttribute("result","delsuccess");
		return "redirect:review";
	}
	//수정하기
	@GetMapping("modify_form")
	public String modify_form(@RequestParam int reviewNum, Model model) {
		bs.getuserData(reviewNum, model);
		return "board/modify_form";
	}
	//수정하기 저장
	@PostMapping("modify")
	public String modify(boardDTO dto, RedirectAttributes rs){
		bs.modify(dto);
		rs.addFlashAttribute("result","modify success");
		return "redirect:review";
	}

	//공지사항 부분
	//공지사항 목록
	@GetMapping("notice")
	public String noticeList(Model model) { 
		bs.noticeList(model);
		System.out.println("공지사항 페이지 연결");
		return "board/notice";
	}

	//글쓰기
	@GetMapping("noticeWrite")
	public String noticeWrite(HttpSession session) {
		return "board/noticeWrite";
	}

	//글저장하기
	@PostMapping("noticeSave")
	public String noticeSave(noticeDTO notice, RedirectAttributes rs) {                   

		System.out.println("저장하기 실행");
		bs.noticeSave(notice);
		rs.addFlashAttribute("result", "success");		
		return "redirect:notice";
	}
}
