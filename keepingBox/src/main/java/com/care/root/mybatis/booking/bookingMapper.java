package com.care.root.mybatis.booking;

import com.care.root.booking.dto.bookingDTO;

public interface bookingMapper {
	public void bookingDo(bookingDTO bookingDto );
//	public List<bookingDTO> bookChkList();
//	public bookingDTO bookChkList(int bookingId);
	public bookingDTO bookingInfo(String userId);
	public int bookDelete(int bookingId);

}
