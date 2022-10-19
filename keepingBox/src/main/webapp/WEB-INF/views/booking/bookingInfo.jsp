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
			<h2>나의 예약정보</h2>
			<div>
				<input type="hidden" value="${booking.bookingId  }"
					readonly="readonly">
			</div>
			<!-- 
			<c:if test="${successLoginUser == userBookingCheck.userId  }">
			</c:if>
			
			 -->
			<div>
				<table class="booking-check">
					<c:choose>
						<c:when test="${empty booking }">
  								예약 정보가 없습니다.
  							  							</c:when>
						<c:otherwise>
								<tr>
									<th scope="row">예약자</th>
									<td>${booking.name }</td>
								</tr>
								<tr>
									<th scope="row">예약일자</th>
									<td>${booking.bookDateS }-${booking.bookDateE }</td>
								</tr>
								<tr>
									<th scope="row">예약일자</th>
									<td>${booking.bookDateE }</td>
								</tr>
								<tr>
									<th scope="row">지점명</th>
									<td>${booking.city }</td>
								</tr>
								<tr>
									<th scope="row">사이즈</th>
									<td>${booking.size }</td>
								</tr>
								<tr>
									<th scope="row">이용요금</th>
									<td>${booking.price }</td>
								</tr>
						</c:otherwise>
					</c:choose>
				</table>
				<button type="button" id="delete-btn"
					onclick="location.href='${contextPath }/booking/bookDelete?bookingId=${booking.bookingId }'">취소하기</button>
				<button type="button" id="List-btn"
					onClick="location.href='${contextPath}/index'">메인으로</button>

			</div>
		</div>
	</main>
	<script type="text/javascript">
		$("#delete-btn").on("click", function(e) {
			if (confirm("예약을 취소하시겠습니까?")) {
				alert('예약이 취소되었습니다.');
				return true;
			} else {
				alert('예약을 취소할 수 없습니다.');
				return false;
			}
		});
	</script>
</body>
<c:import url="../include/footer.jsp" />
</html>