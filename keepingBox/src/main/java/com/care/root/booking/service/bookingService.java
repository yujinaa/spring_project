package com.care.root.booking.service;


import org.springframework.ui.Model;

import com.care.root.booking.dto.bookingDTO;

public interface bookingService {
	public void bookingDo(bookingDTO bookingDto );
	
	//예약정보
//	public void bookChkList(int bookingId,Model model); 
	public bookingDTO bookingInfo(String userId); 
	
	//삭제
	public int bookDelete(int bookingId);
}
