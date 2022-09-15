package com.care.board.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class boardFileServiceImpl implements boardFileService{
	public String getMessage(int num, HttpServletRequest request) {
		String message = null;
		if(num == 1) {
			message = "<script>alert('새글을 추가하였습니다.');";
			message += "location.href='"+request.getContextPath()+ "/board/list'</script>";
		}else {
			message = "<script>alert('글을 저장할 수 없습니다.');";
			message += "location.href='"+request.getContextPath()+ "/board/write'</script>";
		}
		return message;
	}
	public String saveFile(MultipartFile file) {
		SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddHHmmss-");
		Calendar calendar = Calendar.getInstance();
		String sysFileName = 
			simpl.format(calendar.getTime()) + file.getOriginalFilename();
		File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
		try {
			file.transferTo(saveFile);//해당 위치에 파일 저장
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sysFileName;
	}
	public void deleteImg(String originFileName) {//파일받고
		File deleteFile = new File(IMAGE_REPO+"/"+originFileName);//해당경로 얻어오고
		deleteFile.delete();//그 파일 지우기
}
	//alert 메시지는 반복사용할 수 있게 하기
	public String getMessage(HttpServletRequest request,String msg, String url) {
		    String message = null;
		    String path = request.getContextPath();
		  
			message = "<script>alert('"+msg+"');";
			message += "location.href='"+path+ url +"'</script>";
		  
		    return message;
		}
}
