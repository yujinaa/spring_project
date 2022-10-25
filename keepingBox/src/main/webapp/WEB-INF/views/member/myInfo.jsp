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
<c:import url="../include/header.jsp" />
<body>
	<main id="container">
		<div class="mypage-box">
			<h2>마이페이지</h2>
			<div>
				<form class="cf">
					<!-- 
					<c:if test="${not empty param.id }">
					</c:if>
 					-->
					<label for="id">아이디</label> 
					<input type="text" name="id" id="id" value="${info.id }" readonly> 
					<label for="pwd">비밀번호</label>
					<input type="password" name="pwd" id="pwd" value="${info.pwd }"
						class="user-margin" readonly> 
					<label for="name">이름</label> 
					<input type="text" value="${info.name }" name="name" id="name" readonly> 
					<label for="phone">휴대폰 번호 (-없이)</label> 
					<input type="tel" name="phone" id="phone" value="${info.phone }" readonly> 
					<label for="email">이메일</label> <input type="email" name="email"
						value="${info.email }" id="email" readonly>
					<label for="booking">예약정보</label>
					<a href="${contextPath }/booking/bookingInfo">예약현황 확인하기</a>
					<button type="button" id="modify-btn" 
					onclick="location.href='${contextPath }/member/myInfoModify?id=${info.id }'">수정하기 &gt;</button>
					<button type="button" onclick="location.href='${contextPath }/member/deleteMember'">회원탈퇴하기</button>
				</form>
			</div>
		</div>
	</main>
	<c:import url="../include/footer.jsp" />
</body>
</html>