<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/login.css">
<link rel="stylesheet"
	href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<title>로그인</title>
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>
	<c:import url="../include/header.jsp" />
	<main id="container">
		<div class="login-box">
			<h2>로그인</h2>
			<div>
				<form action="/root/member/user_check" method="post">
					<div class="user-box">
						<input type="text" name="id" id="id" required=""> <label
							for="id">아이디</label>
					</div>
					<div class="user-box">
						<input type="password" name="pwd" id="pwd" required=""
							class="user-margin"> <label for="pwd">비밀번호</label>
					</div>
					<div class="save-find">
						<input type="checkbox" name="autoLogin" class="check-box">로그인
						유지
						<ul class="find">
							<li><a href="${contextPath }/member/findId">아이디찾기</a></li>
							<li><a href="${contextPath }/member/findPwd">비밀번호찾기</a></li>
						</ul>
					</div>

					<button type="submit" id="btn">로그인</button>
					<ul class="member-join">
						<li><a href="register_form">회원가입</a></li>
					</ul>
					<div class="kakaoBTN">
						<a
							href="https://kauth.kakao.com/oauth/authorize?client_id=6cfbb25d1642a05ea21e31ecb13db43c&redirect_uri=http://localhost:8084/root/member/kakaoCallback&response_type=code"><img
							alt="카카오로그인" src="${contextPath }/resources/img/kakaoBtn.png"
							></a>
					</div>
				</form>
			</div>
		</div>
	</main>
	<c:import url="../include/footer.jsp" />
	<script src="../resources/js/login.js"></script>
</body>
</html>