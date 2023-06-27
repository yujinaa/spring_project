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
	
	//이전글 다음글
	public boardDTO prevNext(int reviewNum);
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
	public ArrayList<boardDTO> selectSearch(@Param("type")String type,@Param("keyword")String keyword,@Param("s") int start, @Param("e") int end)throws Exception;
	public int selectSearchCount(@Param("type")String type,@Param("keyword")String keyword);




}
