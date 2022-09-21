package com.care.board.mybatis.board;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.care.board.board.dto.boardDTO;
import com.care.board.board.dto.boardReplyDTO;

public interface BoardMapper {
	public java.util.List<boardDTO> boardList(@Param("s")int start,@Param("e")int end);//2이상이 값이 넘어가기 때문에 param사용했다
	public int writeSave(boardDTO dto);
	public boardDTO writeView(int writeNum);
	public void upHit(int writeNum);
	public int delete(int writeNum);
	public void getData(int writeNum, Model model);
	public int modify(boardDTO dto);
	public int addReply(boardReplyDTO dto);
	public List<boardReplyDTO> getReplyList( int repltGroup);
	public int selectBoardCount();
}
