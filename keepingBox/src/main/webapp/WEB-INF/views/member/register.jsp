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
<title>회원가입</title>
<link rel="stylesheet" href="../resources/css/join.css">
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>

	<header>
		<div class="head-wrap">
			<h1>
				<a href="${contextPath }/index"><img src="/resources/img/logo.png" alt="logo"></a>
			</h1>
			<nav>
				<ul>
					<li><a href="booking.html">예약하기</a></li>
					<li><a href="#">이용후기</a></li>
					<c:choose>
                    	<c:when test="${successLoginUser !=null}">
                    		<li><a href="${contextPath }/member/logout">로그아웃</a></li>       
                    	</c:when>
                    	<c:otherwise>
		                    <li><a href="${contextPath }/member/login">로그인</a></li>                    	
                    	</c:otherwise>
                    </c:choose>
				</ul>
			</nav>
		</div>
	</header>

	<main id="container">
		<div class="login-box">
			<h2>회원가입</h2>
			<div>
				<form action="register" method="post">
					<label for="id">아이디</label> <input type="text" name="id" id="id"
						placeholder="4~12자의 영문 대소문자와 숫자만 입력">
					<button type="button" class="chk-btn" onclick="checkId()">중복확인</button>

					<label for="pwd">비밀번호</label> <input type="password" name="pwd"
						id="pwd" class="user-margin" placeholder="4~12자의 영문 대소문자와 숫자만 입력">

					<label for="pwdchk">비밀번호 확인</label> <input type="password"
						name="pwdchk" id="pwdchk"> <label for="name">이름</label> <input
						type="text" name="name" id="name"> <label for="phone">휴대폰
						번호 (-없이)</label> <input type="tel" name="phone" id="phone"> <label
						for="email">이메일</label> <input type="email" name="email"
						id="email" placeholder="example@gmail.com">
					<button type="button" class="chk-btn">전송하기</button>

					<button type="submit" onclick="register();" id="join-btn">회원가입</button>
					<!-- 나중에 type="submit"으로 해보기 -->
				</form>
			</div>
		</div>
	</main>
	<footer>
		<div class="cf">
			<ul class="footer-left">
				<li><span class="en">Keeping<br>Box
				</span></li>
				<li>(주)Keeping Box | 사업자등록번호: 123-45-67899 | 대표이사: 김김김</li>
				<li>주소: 서울특별시 마포구 아현동 백범로</li>
				<li>COPYRIGHTⓒ 2022 KEEPINGBOX KOREA INC. ALL RIGHTS RESERVED</li>
			</ul>
			<ul class="footer-right">
				<li>고객센터 1111-1111</li>
				<li>월~금 9:00~18:00 (공휴일 · 주말 휴무)</li>
			</ul>
		</div>
	</footer>

	<script src="../resources/js/join.js"></script>
</body>
</html>