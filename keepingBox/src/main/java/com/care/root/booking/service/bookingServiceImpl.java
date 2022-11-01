package com.care.root.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

	//회원목록,페이징
	public void memBookList(Model model,int num) {
		int pageLetter = 10;
		int allCount = bMapper.selectMemberCount();
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) {
			repeat += 1;
		}
		int end = num * pageLetter;
		int start = end + 1 -pageLetter;

		model.addAttribute("repeat", repeat);

		model.addAttribute("memBookList", bMapper.memBookList(start, end));
	}
}
