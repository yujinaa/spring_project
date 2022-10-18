package com.care.root.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.booking.dto.bookingDTO;
import com.care.root.member.dto.memberDTO;
import com.care.root.mybatis.booking.bookingMapper;

@Service
public class bookingServiceImpl implements bookingService{
	@Autowired bookingMapper bMapper;
	public void bookingDo(bookingDTO bookingDto ) {
		try {
			bMapper.bookingDo(bookingDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public bookingDTO bookingInfo(String userId, int bookingId){
			bookingDTO dto = null;
			try {
				dto = bMapper.bookingInfo(userId,bookingId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}
	}
