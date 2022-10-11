package com.care.root.booking.service;


import org.springframework.ui.Model;

import com.care.root.booking.dto.bookingDTO;

public interface bookingService {
	public void bookingDo(bookingDTO bookingDto );
	public void info(int bookingId,Model model);

}
