<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
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
				<form action="${contextPath }/booking/bookingDo" method="post"
					class="cf" name="select">
					<!-- 나중에 type:hidden으로 바꾸기 -->
					<input type="hidden" name="userId" id="userId"
						value="${successLoginUser  }">
					<div id="date-group">
						<div id="start-date">
							<label for="start-day">시작일자</label> <input type="date"
								name="bookDateS" id="start-day" class="start-date"
								onchange="checkPrice()">
						</div>
						<div id="end-date">
							<label for="end-day">종료일자</label> <input type="date"
								name="bookDateE" id="end-day" class="end-date"
								onchange="checkPrice()">
						</div>
					</div>
					<label for="bookingName">예약자</label> <input type="text" name="name"
						id="book-name" required="required"> <label
						for="stringcity">지점명</label> <select name="city" id="stringcity">
						<option value="">선택하세요</option>
						<option value="서울">서울 광화문점</option>
						<option value="분당">분당 판교점</option>
						<option value="부천">부천 소사점</option>
					</select> <label for="stringsize">사이즈</label> <select name="size"
						id="stringsize" onchange="checkPrice()">
						<option value="0">선택하세요</option>
						<option value="5000">소 ( 20 x 20 x 45(cm) 이내 )</option>
						<option value="6000">중 (30 x 30 x 60(cm) 이내)</option>
						<option value="7000">대 (50 x 50 x 80(cm) 이내)</option>
					</select> <label for="intmoney">이용요금</label> <input type="text" name="price"
						id="intmoney" class="totalPay" readonly>
						<div style="color: red; font-size: 15px;">*결제 후 예약이 완료됩니다.</div>
					<button type="button" id="money-btn">결제하기</button>
					<button type="submit" id="next-btn" onclick="insertOpt()" disabled="disabled">예약하기</button>
				</form>
			</div>
		</div>
	</main>
	<script src="../resources/js/booking.js"></script>
	<c:import url="../include/footer.jsp" />
</body>
</html>