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

nav# .nav ul li {
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
aside ul li a{
	color: black;
}




</style>
</head>
<body>
	<c:import url="../default/header.jsp" />
	<div class="productplus">

		<ul>
			<li><c:if test="${loginSuccessUser !=null}">
					<a href="#">상품등록</a>
				</c:if></li>
		</ul>
	</div>
	<h2>${loginSuccessUser }관리자님환영합니다</h2>
	<nav class="nav">
		<div class="nav_box"></div>
		<section class="container">
			<aside>
				<ul>
					<li><a href="${contextPath }/admin/product/register">상품 등록</a></li>
					<li><a href="#">상품 목록</a></li> <!-- 등록상품 확인, 상품 수정,삭제 -->
					<li><a href="#">상품 리뷰</a></li>
					<li><a href="#">유저 목록</a></li> <!-- 회원정보 확인 -->
				</ul>
			</aside>
			<div class="container_box">본문</div>
		</section>
	</nav>
</body>
</html>