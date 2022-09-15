package com.care.board.board.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.board.board.dto.boardDTO;
import com.care.board.commonSession.loginSessionName;
import com.care.board.mybatis.board.BoardMapper;

@Service
public class boardServiceImpl implements boardService {
	@Autowired BoardMapper mapper;
//	@Autowired boardFileService bfs;
	public void boardList(Model model) {
		model.addAttribute("boardList", mapper.boardList());
	}

	public String writeSave(MultipartHttpServletRequest multi, HttpServletRequest request) {
		boardDTO dto = new boardDTO(); //사용자가 넘긴 multi,request를 dto에 저장
		dto.setTitle( multi.getParameter("title") );
		dto.setContent( multi.getParameter("content") );
		dto.setWriter(multi.getParameter("writer"));
//		HttpSession session = request.getSession(); //사용자 session을 얻어와서 
//		dto.setWriter((String)session.getAttribute(loginSessionName.LOGIN));//세션을 통해 사용자 id가져오기

		MultipartFile file = multi.getFile("imgFile");
		boardFileService bfs = new boardFileServiceImpl();   //service어노테이션을 넣고 auwired로 주입하면 안써도됨
		if(file.getSize() != 0) {
			dto.setImgFile(bfs.saveFile(file));
		}
		else{
			dto.setImgFile("nan"); //파일이 없다면 nan값으로 dto에 저장
		}
		int result = 0;
		try {//사용자에게 보이면 안되는 오류메시는 전부 예외처리
			result = mapper.writeSave(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bfs.getMessage(result, request); //저장된 dto를 mapper로 전달
	}
}

