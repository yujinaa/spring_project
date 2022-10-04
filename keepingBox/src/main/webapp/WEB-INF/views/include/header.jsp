<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<div class="head-wrap">
			<h1>
				<a href="${contextPath }/index"><img
					src="/root/resources/img/logo.png" alt="logo"></a>
			</h1>
			<nav>
				<ul>
					<li><a href="${contextPath }/member/booking">예약하기</a></li>
					<li><a href="#">이용후기</a></li>
					<c:choose>
						<c:when test="${successLoginUser !=null}">
							<li><a href="${contextPath }/member/logout">로그아웃</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${contextPath }/member/login">로그인</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
	</header>

</body>
</html>