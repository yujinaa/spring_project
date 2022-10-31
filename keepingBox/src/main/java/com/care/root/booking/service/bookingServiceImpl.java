package com.care.root.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.care.root.booking.dto.bookingDTO;
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
	//	public void bookChkList(int bookingId, Model model){
	//		model.addAttribute("bookList",bMapper.bookChkList(bookingId));
	//	}

	//예약정보
	public bookingDTO bookingInfo(String userId){
		bookingDTO dto = null;
				try {
					dto = bMapper.bookingInfo(userId);
				} catch (Exception e) {
					e.printStackTrace();
				}
		return dto;
	}

	//삭제
	public int bookDelete(int bookingId) {
		return bMapper.bookDelete(bookingId);
	}
}
