package com.care.root.board.service;

import java.awt.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.board.dto.boardDTO;
import com.care.root.board.dto.noticeDTO;
import com.care.root.member.dto.memberDTO;

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
	
	
//	public void listAll( String type, String keyword,int num)throws Exception;
//	public int count(String type, String keyword);
	
//	public java.util.List<boardDTO> selectsearch(boardDTO boardDTO) throws Exception;
//	public void selectsearch(boardDTO boardDTO, Model model, String keyword,String type, int num) throws Exception;
//	public void selectsearch(Model model, String type,String keyword, int num) throws Exception;
//	public java.util.List<boardDTO> selectsearch(String type, String keyword); 



}
