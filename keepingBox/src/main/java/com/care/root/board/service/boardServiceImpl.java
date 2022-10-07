package com.care.root.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.board.dto.boardDTO;
import com.care.root.mybatis.board.boardMapper;


@Service
public class boardServiceImpl implements boardService{
	@Autowired boardMapper mapper;
	public void boardList( Model model,int num) {//db로 요청
		int pageLetter = 10;//한 페이지에 10개씩
		int allCount = mapper.selectPageCount(); //총 글에 대한 갯수 얻어오기
		int repeat = allCount / pageLetter;//총 페이지수 구하기
		if(allCount % pageLetter != 0) {
			repeat += 1;
		}
		int end = num * pageLetter;
		int start = end + 1 -pageLetter;

		model.addAttribute("repeat", repeat);
		model.addAttribute("boardList", mapper.boardList(start,end));
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
	//수정하기
	public void getuserData(int reviewNum, Model model) {
		model.addAttribute("userData", mapper.reviewDetail(reviewNum) );

	}
}	