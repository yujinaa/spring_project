package com.care.board.mybatis.board;

import com.care.board.board.dto.boardDTO;

public interface BoardMapper {
	public java.util.List<boardDTO> boardList();
	public int writeSave(boardDTO dto);

}
