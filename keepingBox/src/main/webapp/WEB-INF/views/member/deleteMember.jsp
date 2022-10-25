<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원탈퇴 페이지</h1>
	<div>
		<input type="hidden"
			value="${member.id}" name="id" /> 
			<input type="text"
			name="pwd" placeholder="비밀번호">
		<button type="submit" id="deleteBtn" >회원탈퇴</button>
	</div>
</body>
</html>