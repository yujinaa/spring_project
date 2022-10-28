<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/findIdResult.css">
<title>Insert title here</title>
</head>
<body>
<c:import url="../include/header.jsp" />
	<main id="container">
		<div class="find-box">
			<p class="title">회원님의 아이디를 확인해 주세요</p>
			<div class="result-box">
				<c:choose>
					<c:when test="${empty findId}">
						<p class="inquiry">조회결과가 없습니다.</p>
					</c:when>
					<c:otherwise>
						<p>${findId.id}</p>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="login-pwd">
				<ul class="join-login cf">
					<li><a href="${contextPath }/member/login">로그인하기</a></li>
					<li><a href="${contextPath }/member/findPwd">비밀번호찾기</a></li>
				</ul>
			</div>
		</div>
	</main>
	<c:import url="../include/footer.jsp" />
</body>
</html>