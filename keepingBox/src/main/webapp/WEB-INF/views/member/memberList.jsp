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
<title>회원목록</title>
<link rel="stylesheet" href="../resources/css/review.css">
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>
	<%@ include file="../include/header.jsp"%>
	<main id="container">
		<section class="review">
			<div class="page-title">
				<div class="container">
					<h2>회원목록</h2>
				</div>
			</div>

			<!-- 게시판 리스트 -->
			<div id="board-list">
				<div class="container cf">
					<table class="board-table">
						<thead>
							<tr>
								<th scope="col" class="th-title">아이디</th>
								<th scope="col" class="th-writer">이름</th>
								<th scope="col" class="th-date">연락처</th>
								<th scope="col" class="th-view">이메일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${memberList}" var="list">
								<tr>
									<th><a
										href="${contextPath }/member/memberListDetail?id=${list.id}">${list.id }</a></th>
									<td>${list.name }</td>
									<td>${list.phone }</td>
									<td>${list.email }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div align="center">
						<c:forEach var="num" begin="1" end="${repeat }">
							<a href="memberList?num=${num }">[${num }]</a>
						</c:forEach>
					</div>
					
					<!-- 검색 -->
					<div class="search" align="center" style="margin-top: 40px;">
						<form action="${contextPath }/member/memberList" method="get">
							<input class="inputId" type="text" name="id" value="${param.id }"
								placeholder="찾을 아이디 입력"> <input class="submitBtn"
								type="submit" value="아이디 검색">
						</form>
					</div>


				</div>
			</div>
		</section>
	</main>
	<c:import url="../include/footer.jsp" />
</body>
</html>