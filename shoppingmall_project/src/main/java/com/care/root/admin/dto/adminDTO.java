package com.care.root.admin.dto;
//관리자 dto
public class adminDTO {
	/*
	id varchar2(30) primary key,
    pwd varchar2(100) not null,
    name varchar2(30) not null,
    email varchar2(40),
    phone varchar2(20)
	 * */
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
