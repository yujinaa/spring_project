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
<h1>비밀번호찾기</h1>
	<form id="createForm" action="${contextPath }/member/findPwdCheck" method="post">
		
		<div class="form-group">
			<input type="text" class="form-control form-control-user" id="me_id"
				name="id" placeholder="아이디">
		</div>
		<div class="form-group">
			<input type="text" class="form-control form-control-user"
				id="me_name" name="name" placeholder="이름">
		</div>
		<div class="form-group">
			<input type="email" class="form-control form-control-user"
				id="me_email" name="email" placeholder="이메일">
		</div>
		<button type="submit" onclick="fnSubmit(); return false;"
			class="btn btn-primary btn-user btn-block">비밀번호 찾기</button>
		<hr>
		<div class="text-center">
			<a class="small" href="${contextPath }/member/register_form">회원가입하기</a>
		</div>
		<div class="text-center">
			<a class="small" href="${contextPath }/member/login">이미 계정이
				있으신가요? 로그인하기</a>
		</div>
	</form>
	<script src="../resources/js/findPwd.js"></script>
</body>
</html>