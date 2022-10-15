package com.care.root.board.dto;

import java.text.SimpleDateFormat;

public class noticeDTO {
	private int noticeNum;
	private String title;
	private String content;
	private String saveDate;
	private String writer;
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
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
	public String getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(java.sql.Timestamp saveDate) {//sql date는 시간이 안나옴
		SimpleDateFormat fo = new SimpleDateFormat("YYYY-MM-dd");
		this.saveDate = fo.format(saveDate);
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

}
