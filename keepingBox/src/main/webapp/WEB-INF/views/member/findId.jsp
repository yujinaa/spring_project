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
	<form id="createForm" action="findIdCheck" method="post">
		<div class="form-group">
			<input type="text" class="form-control form-control-user"
				id="me_name" name="name" placeholder="Enter name...">
		</div>
		<div class="form-group">
			<input type="email" class="form-control form-control-user"
				id="me_tel" name="email" placeholder="Enter email...">
		</div>
		<button type="submit" onclick="fnSubmit(); return false;"
			class="btn btn-primary btn-user btn-block">아이디 찾기</button>
		<hr>
		<div class="text-center">
			<a href="${contextPath }/member/register_form">회원가입하기</a>
		</div>
		<div class="text-center">
			<a href="${contextPath }/member/login">로그인하기</a>
		</div>

	</form>
	<script src="../resources/js/findId.js"></script>
</body>
</html>