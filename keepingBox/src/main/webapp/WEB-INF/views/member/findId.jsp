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
<link rel="stylesheet" href="../resources/css/findId.css">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../include/header.jsp" />
	<main id="container">
		<div class="find-box">
			<h2>아이디 찾기</h2>
			<div>
				<form id="findForm" action="${contextPath }/member/findIdCheck"
					method="post">
					<div class="form-group">
						<input type="text" name="name" id="name" placeholder="이름">
					</div>
					<div class="form-group">
						<input type="email" name="email" id="email" placeholder="이메일">
					</div>
					<button type="submit" id="id-find"
						onclick="findSubmit(); return false;">아이디 찾기</button>
					<div>
						<ul class="join-login">
							<li><a href="${contextPath }/member/register_form">회원가입하기</a></li>
							<li><a href="${contextPath }/member/login">로그인하기</a></li>
						</ul>
					</div>
				</form>
			</div>
		</div>
	</main>
	<c:import url="../include/footer.jsp" />
	<script src="../resources/js/findId.js"></script>
</body>
</html>