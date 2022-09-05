package com.care.root.mybatis.admin;


import com.care.root.admin.dto.adminDTO;
import com.care.root.product.dto.productDTO;
import com.sun.tools.javac.util.List;

public interface AdminMapper {
	public adminDTO adminCheck(String id);
	public List<productDTO> productList();

}
