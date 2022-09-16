package com.care.board.board.dto;
//댓글달기 dto

import java.sql.Timestamp;

public class boardReplyDTO {
	/*
	 replyer varchar(20) not null,
title varchar(50)not null,--제목도 비어있음 안되기에 꼭 적는다
reply_content varchar(300),
reply_group number(10) not null,
reply_date date default sysdate,
	 * */

	private String replyer;
	private String title;
	private String replyContent;
	private int replyGroup;
	private Timestamp replyDate;
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public int getReplyGroup() {
		return replyGroup;
	}
	public void setReplyGroup(int replyGroup) {
		this.replyGroup = replyGroup;
	}
	public Timestamp getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}
}
	