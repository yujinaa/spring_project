package com.care.root.booking.service;


import org.springframework.ui.Model;

import com.care.root.booking.dto.bookingDTO;
import com.care.root.member.dto.memberDTO;

public interface bookingService {
	public void bookingDo(bookingDTO bookingDto );
	
	//예약정보
	public bookingDTO bookingInfo(String userId, int bookingId); 

}
