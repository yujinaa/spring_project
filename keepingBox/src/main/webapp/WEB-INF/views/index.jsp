<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Keeping Box</title>
<link rel="stylesheet" href="/root/resources/css/main.css">
<link rel="stylesheet"
	href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>

<c:import url="include/header.jsp"/>

	<main id="container">
		<div class="banner">
			<img src="/root/resources/img/banner.jpg" alt="banner">
			<ul>
				<li>내 주변 짐 보관 서비스</li>
				<li>하루 단위로 언제든지 당신의 짐을 보관할 수 있는<br>맞춤형 서비스입니다
				</li>
				<li><a href="${contextPath }/member/booking" class="button">예약하기</a></li>
			</ul>
		</div>
		<!-- 이용안내 부분 -->
		<section id="info-use">
			<h3>이용안내</h3>
			<div>
				<ul class="all-step">
					<li class="step1 ani ani-up">
						<ul class="steps">
							<li><img src="/root/resources/img/lock.png" alt="join"></li>
							<li>회원가입/로그인</li>
						</ul>
					</li>
					<li><i class="xi-play"></i></li>
					<li class="step2 ani ani-up">
						<ul class="steps">
							<li><img src="/root/resources/img/calendar.png" alt="calendar"></li>
							<li>사이즈, 장소, 날짜 선택</li>
						</ul>
					</li>
					<i class="xi-play"></i>
					<li class="step3 ani ani-up">
						<ul class="steps">
							<li><img src="/root/resources/img/check-mark.png" alt="checkmark"></li>
							<li>결제 후 예약 완료</li>
						</ul>
					</li>
				</ul>
			</div>
		</section>
		<!-- 규격/요금 부분 -->
		<div class="bg-color">
			<section id="info-size">
				<h3>규격/요금</h3>
				<div class="cf">
					<ul class="info-size2">
						<li><span>&#8251;</span>가로&#215;세로&#215;높이(cm)</li>
						<li>요금은 1일 기준로 예약 가능</li>
					</ul>
				</div>
				<div>
					<ul class="all-size">
						<li class="small-box">
							<ul>
								<li><img src="/root/resources/img/box.png" alt="smallbox"></li>
								<li class="box-font">소</li>
								<li class="font-bold">20&#215;20&#215;45(cm) 이내</li>
								<li class="price font-bold">5000원</li>
							</ul>
						</li>
						<li class="middle-box">
							<ul>
								<li><img src="/root/resources/img/box.png" alt="middlebox"></li>
								<li class="box-font">중</li>
								<li class="font-bold">30&#215;30&#215;60(cm) 이내</li>
								<li class="price font-bold">6000원</li>
							</ul>
						</li>
						<li class="big-box">
							<ul>
								<li><img src="/root/resources/img/box.png" alt="bigbox"></li>
								<li class="box-font">대</li>
								<li class="font-bold">50&#215;50&#215;80(cm) 이내</li>
								<li class="price font-bold">7000원</li>
							</ul>
						</li>
					</ul>
				</div>
			</section>
		</div>
		<!-- 지점안내 부분 -->
		<section id="info-place">
			<h3>지점안내</h3>
			<div class="all-place cf">
				<p>
					<img src="/root/resources/img/place1.jpg" alt="place1">
				</p>
				<ul>
					<li>서울 광화문점</li>
					<li><div class="line"></div></li>
					<li>서울 종로구 종로 1 교보생명빌딩 지하1층</li>
					<li>02-123-4567</li>
				</ul>
			</div>
			<div class="all-place cf">
				<p>
					<img src="/root/resources/img/place2.jpg" alt="place2">
				</p>
				<ul>
					<li>분당 판교점</li>
					<li><div class="line"></div></li>
					<li>경기 성남시 분당구 운중로225번길 37 판교도서관</li>
					<li>031-234-5678</li>
				</ul>
			</div>
			<div class="all-place cf">
				<p>
					<img src="/root/resources/img/place3.jpg" alt="place3">
				</p>
				<ul>
					<li>부천 소사점</li>
					<li><div class="line"></div></li>
					<li>경기 부천시 양지로92번길 40-4</li>
					<li>031-345-6789</li>
				</ul>
			</div>
		</section>
	</main>
<c:import url="include/footer.jsp"/>
<script src="/root/resources/js/main.js"></script>
</body>
</html>