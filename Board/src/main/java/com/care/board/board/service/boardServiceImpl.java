package com.care.board.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.board.mybatis.board.BoardMapper;

@Service
public class boardServiceImpl implements boardService {
	@Autowired BoardMapper mapper;
	public void boardList(Model model) {
		model.addAttribute("boardList", mapper.boardList());
	}

}
