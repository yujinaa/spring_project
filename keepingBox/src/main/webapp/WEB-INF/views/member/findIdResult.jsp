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
	<div class="text-center">
		<h1 class="h4 text-gray-900 mb-2">Please check your ID</h1>
		<br> <br>
		<c:choose>
			<c:when test="${empty findId}">
				<p class="mb-4">조회결과가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<p class="mb-4">${findId.searchId}</p>
			</c:otherwise>
		</c:choose>
	</div>
	<hr>
	<div class="text-center">
		<a class="small" href="${contextPath }/member/findPwd">Forgot Your ID?</a>
	</div>
</body>
</html>