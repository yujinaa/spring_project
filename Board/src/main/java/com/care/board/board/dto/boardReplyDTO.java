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
	private String reply_content;
	private int reply_group;
	private Timestamp reply_date;
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
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public int getReply_group() {
		return reply_group;
	}
	public void setReply_group(int reply_group) {
		this.reply_group = reply_group;
	}
	public Timestamp getReply_date() {
		return reply_date;
	}
	public void setReply_date(Timestamp reply_date) {
		this.reply_date = reply_date;
	}
}
