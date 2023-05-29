package com.care.root.mybatis.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.care.root.board.dto.boardDTO;
import com.care.root.board.dto.noticeDTO;
import com.care.root.member.dto.memberDTO;

public interface boardMapper {
	public List<boardDTO> boardList(@Param("s") int start, @Param("e") int end);//2개이상 값 넘기기위해 param사용
	public void writeSave(boardDTO dto) ;
	public boardDTO reviewDetail(int reviewNum);
	public void hitNum(int reviewNum);
	public int delete(int reviewNum);
	public int selectPageCount();
	public int modify(boardDTO dto);


	//공지사항
	public List<noticeDTO> noticeList();
	public void noticeSave(noticeDTO notice) ;
	public noticeDTO noticeDetail(int noticeNum);
	public int modifySave(noticeDTO notice);
	public int noticeDelete(int noticeNum);

	//검색
	//	public java.awt.List getSearchList(String string, boardDTO dto);

	//	public java.awt.List listAll(@Param("type") String type, Map<String, String> map);
	//	public int count(@Param("type")String type, Map<String, String> map);

	public ArrayList<boardDTO> selectsearch(@Param("type")String type,@Param("keyword")String keyword,@Param("s") int start, @Param("e") int end) throws Exception;
	//	public void selectsearch(boardDTO boardDTO, Model model) throws Exception;
	public Integer selectSearchCount(String type, String keyword);
	//	public List<boardDTO> selectsearch(Map<String, String> searchParam);




}
