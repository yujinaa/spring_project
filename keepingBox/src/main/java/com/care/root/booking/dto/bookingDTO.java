package com.care.root.booking.dto;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;



public class bookingDTO {
	private int bookingId;
	private String userId;
	private Date bookDateS;
	private Date bookDateE;
	private String name;
	private String city;
	private String size;
	private String price;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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

	public Date getBookDateS() {
		return bookDateS;
	}

	public Date getBookDateE() {
		return bookDateE;
	}
	public void setSize(String size) {
		this.size = size;
	}
//		public void setBookDateS(java.sql.Timestamp bookDateS) {
//			SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			this.bookDateS = fo.format(bookDateS);
//		}


	//	public void setBookDateE(java.sql.Timestamp bookDateE) {
	//		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
	//		this.bookDateE = fo.format(bookDateE);
	//	}
	public String getPrice() {
		return price;
	}
	public void setBookDateS(Date bookDateS) {
		this.bookDateS = bookDateS;
	}
	public void setBookDateE(Date bookDateE) {
		this.bookDateE = bookDateE;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
