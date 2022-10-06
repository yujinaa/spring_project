package com.care.root.board.service;




import org.springframework.ui.Model;

import com.care.root.board.dto.boardDTO;

public interface boardService {
	public void boardList(Model model);
	public void writeSave(boardDTO dto) ;
	public void reviewDetail(int reviewNum, Model model);
	public int delete(int reviewNum);



}
