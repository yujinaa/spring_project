package com.care.root.booking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

	//예약정보 원래코드
//	public bookingDTO bookingInfo(String userId){
//		bookingDTO dto = null;
//		try {
//			dto = bMapper.bookingInfo(userId);
////			model.addAttribute("booking", bMapper.bookingInfo());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dto;
//	}

	public bookingDTO bookingInfo(String userId){
		return bMapper.bookingInfo(userId);
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
