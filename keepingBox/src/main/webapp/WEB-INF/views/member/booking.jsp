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
<title>예약하기</title>
<link rel="stylesheet" href="../resources/css/booking.css">
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>
	<%@ include file="../include/header.jsp"%>
	<main id="container">
		<div class="booking-box">
			<h2>예약하기</h2>
			<div>
				<form name="booking" method="post" class="cf">
					<div id="date-group">
						<div id="start-date">
							<label for="start-day">시작일자</label> <input type="date"
								name="start-day" id="start-day" class="start-date"
								onchange="checkPrice()">
						</div>
						<div id="end-date">
							<label for="end-day">종료일자</label> <input type="date"
								name="end-day" id="end-day" class="end-date"
								onchange="checkPrice()">
						</div>
					</div>

					<label for="stringcity">지점명</label> <select name="stringcity"
						id="stringcity">
						<option value="">선택하세요</option>
						<option value="seoul">서울 광화문점</option>
						<option value="bundang">분당 판교점</option>
						<option value="bucheon">부천 소사점</option>
					</select> <label for="stringsize">사이즈</label> <select name="stringsize"
						id="stringsize" onchange="checkPrice()">
						<option value="0">선택하세요</option>
						<option value="5000">소 ( 20 x 20 x 45(cm) 이내 )</option>
						<option value="6000">중 (30 x 30 x 60(cm) 이내)</option>
						<option value="7000">대 (50 x 50 x 80(cm) 이내)</option>
					</select> <label for="intmoney">이용요금</label> <input type="text"
						name="intmoney" id="intmoney" readonly>

					<button type="submit" id="next-btn">다음</button>
				</form>
			</div>
		</div>
	</main>
	<script src="../resources/js/booking.js"></script>
	<c:import url="../include/footer.jsp" />
</body>
</html>