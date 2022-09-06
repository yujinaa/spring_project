package com.care.board.member.dto;

public class memberDTO {

	/*
	 	user_id varchar2(30) primary key,
		user_pwd varchar2(100) not null,
		user_name varchar2(20) not null,
		user_email varchar2(30) not null,
		user_type number default 1 --관리자 0, 회원1
	 * */
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


}
