package com.care.root.product.dto;

public class categoryDTO {
	/*
	 catecode	VARCHAR2(30) primary key NOT NULL,	-- '규칙에 의거해 부여한 코드',
	catename	VARCHAR2(20)	NOT NULL,	--'실제 표시되는 이름',
	catecoderef	VARCHAR2(30) NULL,	--'상위 카테고리가 무엇인지 알려주는 코드'
    foreign key(catecoderef) references category(catecode) 
	 * */
	
	private String cateCode;
	private String cateName;
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateCodeRef() {
		return cateCodeRef;
	}
	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}
	private String cateCodeRef;

}
