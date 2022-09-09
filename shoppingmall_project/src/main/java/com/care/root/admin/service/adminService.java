package com.care.root.admin.service;

import org.springframework.ui.Model;

import com.care.root.product.dto.productDTO;


public interface adminService {
	public int adminCheck(String id, String pwd);
	public String productSave(productDTO dto);

	public void productList(Model model);
}
