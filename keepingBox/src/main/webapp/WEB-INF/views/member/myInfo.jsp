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
<link rel="stylesheet" href="../resources/css/myInfo.css">
</head>
<body>
	${successLoginUser }
	<main id="container">
		<div class="mypage-box">
			<h2>마이페이지</h2>
			<div>
				<form name="member" method="post" class="cf">
					<label for="id">아이디</label> <input type="text" name="id" id="id"
						readonly> <label for="pwd">비밀번호</label> <input
						type="password" name="pwd" id="pwd" class="user-margin" readonly>

					<label for="pwdchk">비밀번호 확인</label> <input type="password"
						name="pwdchk" id="pwdchk" readonly> <label for="name">이름</label>
					<input type="text" name="name" id="name" readonly> <label
						for="phone">휴대폰 번호 (-없이)</label> <input type="tel" name="phone"
						id="phone" readonly> <label for="email">이메일</label> <input
						type="email" name="email" id="email" readonly>

					<button type="submit" id="modify-btn">수정하기 &gt;</button>
				</form>
			</div>
		</div>
	</main>
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
	<input type="button" value="메인으로" class="btn"
		onclick="location.href='/member/main'">
</body>
</html>