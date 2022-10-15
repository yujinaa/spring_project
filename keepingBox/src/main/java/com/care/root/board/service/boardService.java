package com.care.root.board.service;

import org.springframework.ui.Model;

import com.care.root.board.dto.boardDTO;

public interface boardService {
	public void boardList(Model model,int num);
	public void writeSave(boardDTO dto) ;
	public void reviewDetail(int reviewNum, Model model);
	public int delete(int reviewNum);
	public void getuserData(int reviewNum, Model model);
	public int modify(boardDTO dto);
	
	//공지사항
	public void noticeList(Model model);




}
