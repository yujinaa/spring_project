<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/findPwdResult.css">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../include/header.jsp" />
	<main id="container">
		<div class="find-box">
				<p class="title">회원님의 임시 비밀번호 입니다</p>
				<div class="result-box">
					<p>${newPwd}</p>
				</div>
				<div class="announce">
					<p class="color2">&#8251;안전을 위해 비밀번호를 변경해 주세요.</p>
				</div>
			<div class="login-pwd">
				<ul class="join-login cf">
					<li><a href="${contextPath }/member/login">로그인</a></li>
				</ul>
			</div>
		</div>
	</main>
	<c:import url="../include/footer.jsp" />
</body>
</html>