package com.care.board.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.board.board.service.boardFileService;
import com.care.board.board.service.boardService;
import com.care.board.commonSession.loginSessionName;

@Controller
@RequestMapping("board")
public class boardController implements loginSessionName{	
	@Autowired boardService bs;
	
	//게시판 목록
	@GetMapping("list")
	public String board(HttpSession session, Model model) { //db에 저장된 모든 값 가져오기
		bs.boardList(model);
		if(session.getAttribute(LOGIN) != null) {
			return "board/list";			
		}
		return "member/login";
	}
	//글쓰기
	@GetMapping("write")
	public String writeFrom() {
		return "board/write";
	}
	//글저장하기
	@PostMapping("writeSave")
	public void writeSave(MultipartHttpServletRequest multi, HttpServletResponse response,   //작성자가 글쓰기 누르면 모든값이 multi에 들어옴,  //out 객체를 만들어 사용자에게 전달
							HttpServletRequest request) throws IOException{                    //request는 경로 설정
		System.out.println("read:" +multi.getParameter("writer"));
		System.out.println("저장하기 실행");
		String message =bs.writeSave(multi, request);//multi는 사용자 모든정보, request는 세션이나 절대경로
		PrintWriter out= null;
		response.setContentType("text/html; charset = utf-8");
		out = response.getWriter();
		out.println(message);
	}
	//게시글 조회페이지
	@GetMapping("writeView")
	public String writeView(@RequestParam int writeNum, Model model) { //게시글번호, 내용담기 위한 model
		bs.writeView(writeNum,model);
		return "board/writeView";
	}
	//게시글 조회- 이미지 불러오기
	@GetMapping("imageView")
	public void imgView(@RequestParam("imgFile") String imgFile,
		HttpServletResponse response) throws IOException {
	    response.addHeader(
		"Content-disposition","attachment;fileName="+imgFile); //파일을 다운받고, 브라우저로 표현하고, 다운될 파일이름
	    File file = new File(boardFileService.IMAGE_REPO+"/"+imgFile);
	    FileInputStream in = new FileInputStream(file);
	    FileCopyUtils.copy(in, response.getOutputStream());
	    in.close();
}
}
