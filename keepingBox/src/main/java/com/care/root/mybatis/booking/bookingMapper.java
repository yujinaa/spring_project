package com.care.root.mybatis.booking;


import com.care.root.booking.dto.bookingDTO;

public interface bookingMapper {
	public void bookingDo(bookingDTO bookingDto );
	public bookingDTO info(int bookingId);

}
