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
<title>이용후기</title>
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
					<h2>이용후기</h2>
				</div>
			</div>

			<!-- 게시판 리스트 -->
			<div id="board-list">
				<div class="container cf">
					<table class="board-table">
						<thead>
							<tr>
								<th scope="col" class="th-num">번호</th>
								<th scope="col" class="th-title">제목</th>
								<th scope="col" class="th-writer">글쓴이</th>
								<th scope="col" class="th-date">작성날짜</th>
								<th scope="col" class="th-view">조회수</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${boardList}" var="dto">
							<tr>
								<td>${dto.reviewNum }</td>
								<th><a href="${contextPath }/board/reviewDetail?reviewNum=${dto.reviewNum}">${dto.title }</a></th>
								<td>${dto.writer }</td>
								<td>${dto.regDate }</td>
								<td>${dto.hitNum }</td>
							</tr>
						</c:forEach>	
						</tbody>
					</table>
					<!-- <select name="period" id="period">
                        <option value="">일주일</option>
                        <option value="">한달</option>
                        <option value="">전체</option>
                    </select> -->
					<a href="${contextPath }/board/reviewWrite"><button type="submit" id="review-btn">리뷰쓰기</button></a>
				</div>
			</div>
		</section>
	</main>
	<c:import url="../include/footer.jsp" />
</body>
</html>