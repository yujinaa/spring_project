package com.care.root.booking.dto;

import java.util.Date;

public class bookingDTO {
	/*
	 booking_id varchar2(20) not null,
buser_id varchar2(20) not null,
booking_date_start date default sysdate,
booking_date_end  date default sysdate,
booking_name varchar2(20) not null,
booking_city varchar2(40) not null,
booking_size varchar2(20) not null,
booking_price number not null,
primary key(booking_id),
	 */
private String bookingId;
private String userId;
private String bookDateS;
private String bookDateE;
private String name;
private String city;
private String size;
private int price;
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

public String getBookingId() {
	return bookingId;
}
public void setBookingId(String bookingId) {
	this.bookingId = bookingId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}

public String getBookDateS() {
	return bookDateS;
}
public void setBookDateS(String bookDateS) {
	this.bookDateS = bookDateS;
}
public String getBookDateE() {
	return bookDateE;
}
public void setBookDateE(String bookDateE) {
	this.bookDateE = bookDateE;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
}
