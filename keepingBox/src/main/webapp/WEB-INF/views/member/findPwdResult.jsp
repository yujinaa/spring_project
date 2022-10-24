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
				회원님 임시 비밀번호는 <p class="mb-4">${newPwd}</p>
	</div>
	<hr>
	
	<div class="text-center">
		<a class="small" href="${contextPath }/member/login">이미 계정이 있으신가요?
			로그인하기</a>
	</div>
</body>
</html>