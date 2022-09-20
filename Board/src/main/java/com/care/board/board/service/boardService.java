package com.care.board.board.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.board.board.dto.boardReplyDTO;

public interface boardService {
	public void boardList(Model model);
	public String writeSave(MultipartHttpServletRequest multi, HttpServletRequest request);
	public void writeView(int writeNum, Model model);
	public String writeDelete(int writeNum,String imgFile, HttpServletRequest request);
	public void getData(int writeNum, Model model);
	public String modify(MultipartHttpServletRequest multi, HttpServletRequest request);
	public String addReply(boardReplyDTO dto);
	public List<boardReplyDTO> getReplyList( int replyGroup);

}
