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
<title>Insert title here</title>
</head>
<body>
	<header>
		<div class="head-wrap">
			<h1>
				<a href="${contextPath }/index"><img
					src="/root/resources/img/logo.png" alt="logo"></a>
			</h1>
			<nav>
				<ul>
				<li><a href="${contextPath }/board/notice">공지사항</a></li>
					<c:choose>
						<c:when test="${successLoginUser =='admin01'}">
							<li><a href="${contextPath }/member/memberList">회원목록</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${contextPath }/booking/booking">예약하기</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="${contextPath }/board/review">이용후기</a></li>
					<c:choose>
						<c:when test="${successLoginUser !=null || email!=null}">
							<li class="mypage"><a href="#">마이페이지</a>
								<ul class="mypage-sub">
									<li><a href="${contextPath }/booking/bookingInfo">예약확인</a></li>
									<li><a href="${contextPath }/member/myInfo">회원정보</a></li>
									<li><a href="${contextPath }/member/myReview">내가 쓴 글</a></li>
									<li id="log-out"><a href="${contextPath }/member/logout">로그아웃</a></li>
								</ul></li>
						</c:when>
						<c:otherwise>
							<li><a href="${contextPath }/member/login">로그인</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
	</header>
	<script type="text/javascript">
		$("#log-out").on("click", function() {
			if (confirm("로그아웃 하시겠습니까?")) {
				alert("로그아웃 되었습니다. 다시 로그인 해 주세요.");
			} else {
				return false;
			}
		});
	</script>
</body>
</html>