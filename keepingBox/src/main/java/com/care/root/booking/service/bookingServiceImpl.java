package com.care.root.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.booking.dto.bookingDTO;
import com.care.root.mybatis.booking.bookingMapper;

@Service
public class bookingServiceImpl implements bookingService{
	@Autowired bookingMapper bMapper;
	public void bookingDo(bookingDTO bookingDto ) {
		bMapper.bookingDo(bookingDto);
	}
}
