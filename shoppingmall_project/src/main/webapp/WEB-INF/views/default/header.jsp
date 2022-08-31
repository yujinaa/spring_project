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
}
.menu{
	position: relative;
	text-decoration: none;
}
.totalMenu ul li a{
	text-decoration: none;
}

.menuleft {
	display: inline-block;
	position : absolute;
	left: 1px;
}
.menuleft li {
	list-style: none;
	display: inline-flex;
}

.menuright {
	display: inline-block;
	position : absolute;
	right: 10px;
	width: 400px;
}
.menuright li {
	list-style: none;
	display: inline-flex;
}



.totalMenu ul li a:hover {
	color: black;
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

.content {
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<h1 class="title"><a href="${contextPath }/index">BLACKUP</a></h1>
		</div>
	
			<nav class="totalMenu">
				<div class="Menu">
					<ul class="menuleft">
					<li><a href="${contextPath }/index">SHOP</a></li>
					<li><a href="${contextPath }/index">NEW</a></li>
					<li><a href="${contextPath }/index">BEST50</a></li>
					</ul>
					<ul class="menuright">
					<li>
						<c:choose>
								<c:when test="${loginSuccessUser != null }"> <!-- 세션이 있다면 로그인한 사용자 -->
									<a href="${contextPath }/member/logout">LOGOUT</a>	<!-- 로그아웃이 뜨고 -->						
								</c:when>
								<c:otherwise> <!-- 그렇지 않은 사용자는 -->
									<a href="${contextPath }/member/login">LOGIN</a> <!-- 로그인이 뜨드록 -->																
								</c:otherwise>
						</c:choose>
					</li>
					
					
					<li><a href="${contextPath }/member/register">ACCOUNT</a></li>
					<li><a href="${contextPath }/index">COMMUNITY</a></li>
				</ul>
				</div>
			</nav>
		</div>
</body>
</html>
