package com.care.board.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface boardFileService {
	public String getMessage(int num, HttpServletRequest request);
	public static final String IMAGE_REPO="C:/spring/image_repo"; //이미지 저장 경로
	public String saveFile(MultipartFile file);//저장이미지 메소드 만들기
	public void deleteImg(String originFileName );
	public String getMessage(HttpServletRequest request,String msg, String url);
}
