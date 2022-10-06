package com.care.root.mybatis.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.care.root.board.dto.boardDTO;

public interface boardMapper {
	public List<boardDTO> boardList(@Param("s") int start, @Param("e") int end);//2개이상 값 넘기기위해 param사용
	public void writeSave(boardDTO dto) ;
	public boardDTO reviewDetail(int reviewNum);
	public void hitNum(int reviewNum);
	public int delete(int reviewNum);
	public int selectPageCount();




}
