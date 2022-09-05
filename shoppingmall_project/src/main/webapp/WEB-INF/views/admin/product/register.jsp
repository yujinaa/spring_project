<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
.inputArea{
	text-align: center;
}
.inputArea label{
	width: 100px;
	height: 30px;
}

h2 {
	text-align: center;
}

.productplus li {
	list-style: none;
}

.productplus li a {
	display: flex;
}

body {
	padding: 0;
	margin: 0;
}

ul {
	padding: 0;
	margin: 0;
	list-style: nones;
}

nav .nav {
	padding: 10px;
	text-align: right;
}

nav # .nav ul li {
	display: inline-block;
	margin-left: 10px;
}

section .container {
	padding: 20px 0;
	border-top: 2px solid #eee;
	border-bottom: 2px solid #eee;
}

section .container::after {
	content: "";
	display: block;
	clear: both;
}

aside {
	float: left;
	width: 200px;
}

div .container_box {
	float: right;
	width: calc(100% - 200px - 20px);
}

aside ul li {
	text-align: center;
	margin-bottom: 10px;
}

aside ul li a {
	color: black;
}
</style>
</head>
<body>
	<c:import url="../../default/header.jsp" />
	<div class="productplus"></div>
	<h2>${loginSuccessUser }관리자님환영합니다</h2>
	<nav class="nav">
		<div class="nav_box"></div>
		<section class="container">
			<aside>
				<ul>
					<li><a href="${contextPath }/admin/product/register">상품 등록</a></li>
					<li><a href="${contextPath }/admin/product/list">상품 목록</a></li>
					<!-- 등록상품 확인, 상품 수정,삭제 -->
					<li><a href="#">상품 리뷰</a></li>
					<li><a href="#">유저 목록</a></li>
					<!-- 회원정보 확인 -->
				</ul>
			</aside>
		</section>
		<form method="post" action="${contextPath}/product/productSave">
			<div class="inputArea">
				<label>1차 분류</label>
				 <select class="category1">
					<option value="">전체</option>
				</select> 
				<label>2차 분류</label> 
				<select class="category2" name="cateCode">
					<option value="">전체</option>
				</select>
			</div>

			<div class="inputArea">
				<label for="productNum">상품번호</label> <input type="text" id="productNum"
					name="productNum" />
			</div>

			<div class="inputArea">
				<label for="productName">상품이름</label> <input type="text" id="productName"
					name="productName" />
			</div>

			<div class="inputArea">
				<label for="cateCode">카테고리번호</label> <input type="text" id="cateCode"
					name="cateCode" />
			</div>
			<div class="inputArea">
				<label for="productPrice">상품가격</label> <input type="text" id="productPrice"
					name="productPrice" />
			</div>
			<div class="inputArea">
				<label for="info">상품정보</label> 
				<textarea rows="5" cols="50" id="info" name="info"></textarea>
			</div>
			<div class="inputArea">
				<label for="productStodck">상품재고</label> <input type="text" id="productStodck"
					name="productStodck" />
			</div>

			<div class="inputArea">
				<input type="submit" value="등록" />	
			</div>

		</form>
	</nav>
</body>
</html>