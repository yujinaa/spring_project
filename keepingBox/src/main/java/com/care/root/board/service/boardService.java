package com.care.root.board.service;


import org.springframework.ui.Model;

import com.care.root.board.dto.boardDTO;
import com.care.root.board.dto.noticeDTO;

public interface boardService {
	public void boardList(Model model,int num);
	public void writeSave(boardDTO dto) ;
	public void reviewDetail(int reviewNum, Model model);
	public int delete(int reviewNum);
	public void getuserData(int reviewNum, Model model);
	public int modify(boardDTO dto);


	//공지사항
	public void noticeList(Model model);
	public void noticeSave(noticeDTO notice) ;
	public void noticeDetail(int noticeNum, Model model);
	public void getdata(int noticeNum, Model model);
	public int modifySave(noticeDTO notice);
	public int noticeDelete(int noticeNum);

	//검색
	public void selectSearch(Model model,String type, String keyword,int num)throws Exception;

}
