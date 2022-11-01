package com.care.root.mybatis.booking;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.care.root.booking.dto.bookingDTO;
import com.care.root.member.dto.memberDTO;

public interface bookingMapper {
	public void bookingDo(bookingDTO bookingDto );
	//	public List<bookingDTO> bookChkList();
	//	public bookingDTO bookChkList(int bookingId);
	public bookingDTO bookingInfo(String userId);
	public int bookDelete(int bookingId);

	//관리자 - 회원예약목록
	public ArrayList<bookingDTO> memBookList(@Param("s") int start, @Param("e") int end);
	public int selectMemberCount();

}
