package com.care.root.member.dto;

import java.awt.List;
import java.sql.Date;

import com.care.root.board.dto.boardDTO;

public class memberDTO {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String sessionId;
	private Date limitTime;
	
	//회원이 작성한 게시글은 여러개 n이라 list 형태로 선언
	private java.util.List<boardDTO> myPageList;
	
	public java.util.List<boardDTO> getMyPageList() {
		return myPageList;
	}
	public void setMyPageList(java.util.List<boardDTO> myPageList) {
		this.myPageList = myPageList;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Date getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
