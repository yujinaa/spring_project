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
${successLoginUser }
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${info.id }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${info.name }</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>${info.phone }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${info.email }</td>
		</tr>
	</table>
	<input type="button" value="메인으로" class="btn" 	onclick="location.href='/member/main'">
</body>
</html>