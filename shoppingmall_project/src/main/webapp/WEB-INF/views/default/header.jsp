<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Fjalla+One&family=PT+Sans+Narrow&display=swap" rel="stylesheet">
* {
	margin: 0;
	font-family: 'PT Sans Narrow', sans-serif;
}

.wrap {
	width: 1200px;
	margin: auto;
}

.header {
	width: 1200px;
	background-color: white;
}
.header a{
	text-decoration: none;
	color: black;
}

.totalMenu {
	background-color: white;
	width: 1200px;
	display: flex;
}
.totalMenu > ul{
	display: inline-block;
	padding: 0 50px;
	cursor: pointer;
	
}
.totalMenu > ul>li{
	float:left;
	padding-right: 80px;
	list-style: none;
} 


.totalMenu ul li a{
	text-decoration: none;
	list-style: none;
	color: black;
}
.totalMenu li{
	position: relative;
}
.totalMenu ul ul{
	display: none;
	position: absolute;
}
.totalMenu li:hover > ul{
	display: block;
}
.community_submenu li{
	list-style: none;
	text-align: center;
}


.totalMenu ul li a:hover {
	padding-bottom: 0.3px; /* a태그 밑줄과 글씨 간격*/
	border-bottom: 1px solid black;
}

.title { 
	font-size: 25pt;
	text-align: center;
	margin-top: 0px;
	color:black; 
	font-family: 'PT Sans Narrow', sans-serif;
	
	<!-- 
	font-family: 'Fjalla One', sans-serif;
	font-family: font-family: 'Bebas Neue', cursive;
	-->

}


</style>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<h1 class="title"><a href="${contextPath }/index">BLACKUP</a></h1>
		</div>
	
			<nav class="totalMenu">
					<ul>
						<li>SHOP
							<ul class="community_submenu">
								<li><a href="${contextPath }/product/outer">아우터</a></li>
								<li><a href="#">탑</a></li>
								<li><a href="#">팬츠</a></li>
								<li><a href="#">스커트 & 드레스</a></li>
							</ul>
						</li>
						<li><a href="${contextPath }/index">NEW</a></li>
						<li><a href="${contextPath }/index">BEST50</a></li>
					</ul>
					<ul >
					<li class="login_menu">
						
						<c:choose>
								<c:when test="${userId != null }"> <!-- 세션이 있다면 로그인한 사용자 -->
									<a href="${contextPath }/member/logout">LOGOUT</a>	<!-- 로그아웃이 뜨고 -->						
								</c:when>
								<c:otherwise> <!-- 그렇지 않은 사용자는 -->
									<a href="${contextPath }/member/login">LOGIN</a> <!-- 로그인이 뜨드록 -->																
								</c:otherwise>
						</c:choose>
					</li>
					
					
					<li><a href="${contextPath }/member/register">ACCOUNT</a></li>
					<li>
						<a href="#">COMMUNITY</a>
						<ul class="community_submenu">
							<li><a href="#">Q&A</a></li>
							<li><a href="#">REVIEW</a></li>
							<li><a href="#">공지사항</a></li>
							<li><a href="#">입사지원</a></li>
						</ul>
					</li>
					
					
				</ul>
			</nav>
		</div>
</body>
</html>
