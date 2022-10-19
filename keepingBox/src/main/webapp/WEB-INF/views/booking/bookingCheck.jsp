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
			<h2>예약확인</h2>
			<input type="hidden" value="${bookList.bookingId}">
			<table>
				<c:if test="${bookList.size() == 0 }">
					<tr>
						<td>저장 데이터 없음</td>
					</tr>
				</c:if>
					<tr class="odd gradeX">
						<td>${dto.userId }ddd</td>
						<td>${dto.name }</td>
						<td>${dto.bookDateS}</td>
						<td>${dto.city }</td>
						<td>${dto.size }</td>
						<td>${dto.price }</td>
					</tr>
			</table>
			<table>
			</table>
		</div>
	</main>
</body>
<c:import url="../include/footer.jsp" />
</html>