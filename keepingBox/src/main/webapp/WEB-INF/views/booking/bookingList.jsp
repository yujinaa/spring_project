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
</head>
<body>
	<table border="1" class="table" style="width: 1100px;">

		<caption>
			<font size="5">예약목록</font>
		</caption>
		<tr>
			<th>사물함번호</th>
			<th>예약여부</th>
			<th>예약날짜</th>
			<th>아이디</th>
			<th>이메일</th>
			<th>예약취소</th>
		</tr>

		<c:choose>
			<c:when test="${empty bookingList }">
				<tr>
					<th colspan="6">검색결과가 없습니다.</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${bookingList }" var="booking">
					<tr>
						<td class="tableId"></td>
						<td>${booking.checkIn }</td>
						<td>${booking.sDate }</td>
						<td>${booking.id }</td>
						<td>${booking.email }</td>
						<th style="width: 80px;"><input type="button" value="예약취소"
							name="cancel" onclick="bookingCancel()"></th>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>
</body>
</html>