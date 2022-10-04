package com.care.root.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.mybatis.board.boardMapper;


@Service
public class boardServiceImpl implements boardService{
	@Autowired boardMapper mapper;
	public void boardList( Model model) {//db로 요청
		model.addAttribute("boardList", mapper.boardList());
	}
}
