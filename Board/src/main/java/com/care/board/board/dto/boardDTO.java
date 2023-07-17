package com.care.board.board.dto;

import java.text.SimpleDateFormat;

public class boardDTO {
	private int writeNum;
	private String title;
	private String content;
	private String regDate;
	private int hitNum;
	private String imgFile;
	private String writer;
	
	public int getWriteNum() {
		return writeNum;
	}
	public void setWriteNum(int writeNum) {
		this.writeNum = writeNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
//	public void setRegDate(String regDate) {
//		this.regDate = regDate;
//	}
	
	//.이 없는 시간으로 변경
	public void setRegDate(java.sql.Timestamp regDate) {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		this.regDate = format.format(regDate);
	}
	public int getHitNum() {
		return hitNum;
	}
	public void setHitNum(int hitNum) {
		this.hitNum = hitNum;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	

}
