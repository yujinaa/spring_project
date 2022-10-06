package com.care.root.board.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.board.dto.boardDTO;
import com.care.root.mybatis.board.boardMapper;


@Service
public class boardServiceImpl implements boardService{
	@Autowired boardMapper mapper;
	public void boardList( Model model) {//db로 요청
		model.addAttribute("boardList", mapper.boardList());
	}
	//글저장
	public void writeSave(boardDTO dto)  {
		try {
			mapper.writeSave(dto);
			String msg = "<script>alert('새글을 추가하였습니다.');";
		} catch (Exception e) {
			String msg = "<script>alert('글을 등록할 수 없습니다.');";
			e.printStackTrace();
		}
	}	
	public void reviewDetail(int reviewNum, Model model) {
		model.addAttribute("detailReview", mapper.reviewDetail(reviewNum) );
	}	
}		
