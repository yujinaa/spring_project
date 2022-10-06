package com.care.root.mybatis.board;

import java.util.List;


import com.care.root.board.dto.boardDTO;

public interface boardMapper {
	public List<boardDTO> boardList();
	public void writeSave(boardDTO dto) ;
	public boardDTO reviewDetail(int reviewNum);
	public void hitNum(int reviewNum);




}
