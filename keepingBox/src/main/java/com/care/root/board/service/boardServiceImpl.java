package com.care.root.board.service;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.care.root.board.dto.boardDTO;
import com.care.root.board.dto.noticeDTO;
import com.care.root.member.dto.memberDTO;
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
		model.addAttribute("detailReview", mapper.reviewDetail(reviewNum) );
	}
	//수정한 글 저장하기
	public int modify(boardDTO dto) {
		return mapper.modify(dto);
	}

	//공지사항 부분
	//공지사항
	public void noticeList(Model model) {
		model.addAttribute("noticeList", mapper.noticeList());
	}

	//글저장
	public void noticeSave(noticeDTO notice)  {
		try {
			mapper.noticeSave(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//상세보기
	public void noticeDetail(int noticeNum, Model model) {
		model.addAttribute("detailNotice", mapper.noticeDetail(noticeNum) );
		hitNum(noticeNum);
	}
	//수정하기
	public void getdata(int noticeNum, Model model) {
		model.addAttribute("detailNotice", mapper.noticeDetail(noticeNum) );
	}
	//수정한 글 저장하기
	public int modifySave(noticeDTO notice) {
		return mapper.modifySave(notice);
	}
	//삭제
	public int noticeDelete(int noticeNum) {
		return mapper.noticeDelete(noticeNum);
	}
	//	public void getReviewList(Model model) {
	//		model.addAttribute("reviewList", mapper.getReviewList() );
	//
	//	}

	//검색하기1방법
	//	public java.util.List<boardDTO> listAll(String type,String keyword){
	//		return mapper.listAll(type, keyword);
	//	}

	//검색방법2
//	public java.util.List<boardDTO> getSearchList(String type,String keyword,boardDTO dto) {
//		return mapper.getSearchList("getSearchList",dto,type,keyword);
//	}
	
	//검색방법3
//	public java.util.List<boardDTO> selectSearch(boardDTO dto) throws Exception{
//		return mapper.selectSearch(dto);
//	}
	public void selectSearch(Model model, String type, String keyword,int num)throws Exception{
		int pageLetter = 5;
		int allCount = mapper.selectSearchCount(type,keyword);
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) {
			repeat += 1;
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;

		model.addAttribute("repeat", repeat);
		model.addAttribute("boardList", mapper.selectSearch(type,keyword, start, end));
	}

	//검색
	//	public List getSearchList(boardDTO dto) {
	//		return mapper.getSearchList("getSearchList",dto);
	//	}

	//	public int count(@RequestParam("type") String type, @RequestParam("keyword")String keyword) {
	//		Map<String, String> map = new HashMap<String, String>();
	//		map.put("type", type);
	//		map.put("keyword", keyword);
	//		return mapper.count("count", map);
	//		
	//	}

	//	public java.util.List<boardDTO> selectsearch(boardDTO boardDTO) throws Exception {
	//		return mapper.selectsearch(boardDTO);
	//	}
	//	public void selectsearch( Model model, String type, String keyword, int num) throws Exception {
	//		int pageLetter = 5;
	//		int allCount = mapper.selectSearchCount(type, keyword);
	//		int repeat = allCount / pageLetter;
	//		if(allCount % pageLetter != 0) {
	//			repeat += 1;
	//		}
	//		int end = num * pageLetter;
	//		int start = end + 1 - pageLetter;
	//
	//		model.addAttribute("repeat", repeat);
	//		model.addAttribute("boardList", mapper.selectsearch(type,keyword, start, end));
	//	}
}