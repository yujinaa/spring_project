package com.care.root.mybatis.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.care.root.board.dto.boardDTO;
import com.care.root.booking.dto.bookingDTO;
import com.care.root.member.dto.memberDTO;

public interface bookingMapper {
	public void bookingDo(bookingDTO bookingDto );
	public bookingDTO bookingInfo(String userId);
	public int bookDelete(int bookingId);

	//관리자 - 회원예약목록
	public ArrayList<bookingDTO> memBookList(@Param("s") int start, @Param("e") int end);
	public int selectMemberCount();
}
