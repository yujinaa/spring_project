package com.care.root.product.dto;

public class productDTO {
	/*
	 prodnum	NUMBER	primary key not null,
	prodname	VARCHAR2(30)	NOT NULL,
    catecode	VARCHAR2(30)	NOT NULL,
	prodprice	NUMBER	NOT NULL,
	prodinfo	VARCHAR2(500)	NULL,
	prodstock	NUMBER	NULL,
	prodimg	VARCHAR2(500)	NULL
	 */
	
	private int prodNum;
	private String prodName;
	private String cateCode;
	private int prodPrice;
	private String info;
	private int prodStock;
	private String prodImg;
	public int getProdNum() {
		return prodNum;
	}
	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getProdStock() {
		return prodStock;
	}
	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}
	public String getProdImg() {
		return prodImg;
	}
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

}
