package com.care.root.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.admin.dto.adminDTO;
import com.care.root.mybatis.admin.AdminMapper;
import com.care.root.product.dto.productDTO;

@Service
public class adminServiceImpl implements adminService{
	@Autowired AdminMapper mapper;
	public int adminCheck(String id, String pwd) {
			adminDTO dto=  mapper.adminCheck(id);
			if(dto != null){
				if(pwd.equals(dto.getPwd())) {
					return 0; //로그인성공시 0 돌려주기
				}
			}
			return 1; //그렇지 않다면 로그인실패로 1 돌려주기
		}
	
	
	public void productList(Model model) {
		
		model.addAttribute("productList", mapper.productList());
	}
}

