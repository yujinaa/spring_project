package com.care.board.board.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface boardService {
	public void boardList(Model model);
	public String writeSave(MultipartHttpServletRequest multi, HttpServletRequest request);
	public void writeView(int writeNum, Model model);
	public String writeDelete(int writeNum,String imgFile, HttpServletRequest request);
	public void getData(int writeNum, Model model);

}
