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
<title>예약확인</title>
<link rel="stylesheet" href="../resources/css/mypage-booking-check.css">
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>
	<c:import url="../include/header.jsp" />
	<main id="container">
		<div class="booking-box">
			<h2>예약정보확인</h2>
			<table>
			
			<c:forEach items="${bookCheck}" var="userBookingCheck">
				<tr class="odd gradeX">
				
					<td>${userBookingCheck.bookingId }</td>
					<td>
							${userBookingCheck.name }</td>
					<td>${userBookingCheck.bookDateS}</td>
					<td>${userBookingCheck.city }</td>
					<td>${userBookingCheck.size }</td>
					<td>${userBookingCheck.price }</td>
				</tr>
			</c:forEach>
			</table>
			<!-- 
			
			<div>
				<input type="text" value="${userBookingCheck.bookingId  }"
					readonly="readonly">
			</div>
			<div>
				<input type="text" value="${ successLoginUser }" readonly="readonly">
			</div>

			<div>
				<table class="booking-check">
					<tr>
						<th scope="row">예약자</th>
						<td>${userBookingCheck.name }</td>
					</tr>
					<tr>
						<th scope="row">예약일자</th>
						<td>${userBookingCheck.bookDateS }</td>
					</tr>
					<tr>
						<th scope="row">지점명</th>
						<td>${userBookingCheck.city }</td>
					</tr>
					<tr>
						<th scope="row">사이즈</th>
						<td>${userBookingCheck.size }</td>
					</tr>
					<tr>
						<th scope="row">이용요금</th>
						<td>${userBookingCheck.price }</td>
					</tr>
				</table>

				<button type="button" id="booking-btn"
					onClick="location.href='${contextPath}/index'">확인</button>
			</div>
			 -->
		</div>
	</main>
</body>
<c:import url="../include/footer.jsp" />
</html>