package com.care.board.board.service;

import javax.servlet.http.HttpServletRequest;

public class boardFileServiceImpl implements boardFileService{
	public String getMessage(int num, HttpServletRequest request) {
		String message = null;
		if(num == 1) {
			message = "<script>alert('새글을 추가하였습니다.');";
			message += "location.href='"+request.getContextPath()+ "/board/list'</script>";
		}else {
			message = "<script>alert('글을 저장할 수 없습니다.');";
			message += "location.href='"+request.getContextPath()+
					"/board/write'</script>";
		}
		return message;
	}

}
