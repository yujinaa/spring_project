package com.care.root.board.service;



import javax.servlet.http.HttpServletRequest;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	//글 상세보기
	public void reviewDetail(int reviewNum, Model model) {
		model.addAttribute("detailReview", mapper.reviewDetail(reviewNum) );
		hitNum(reviewNum);
	}
	//조회수증가
	private void hitNum(int reviewNum) {
		mapper.hitNum(reviewNum);
	}
	//삭제
	public int delete(int reviewNum) {
		return mapper.delete(reviewNum);
	}
}	