package com.care.root.admin.service;

import org.springframework.ui.Model;


public interface adminService {
	public int adminCheck(String id, String pwd);
	public void productList(Model model);
}
