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
<title>공지사항</title>
<link rel="stylesheet" href="../resources/css/notice.css">
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>
	<%@ include file="../include/header.jsp"%>
	<main id="container">
		<section class="notice">
			<div class="page-title">
				<div class="container">
					<h2>공지사항</h2>
				</div>
			</div>

			<!-- 게시판 리스트 -->
			<div id="board-list">
				<div class="container">
					<table class="board-table">
						<thead>
							<tr>
								<th scope="col" class="th-num">번호</th>
								<th scope="col" class="th-title">제목</th>
								<th scope="col" class="th-title">글쓴이</th>
								<th scope="col" class="th-date">등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${noticeList}" var="notice">
								<tr>
									<td>${notice.noticeNum }</td>
									<th><a
										href="${contextPath }/board/noticeDetail?noticeNum=${notice.noticeNum}">${notice.title }</a></th>
									<td>${notice.writer }</td>
									<td>${notice.saveDate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="${contextPath }/board/noticeWrite"><button
							type="submit" id="review-btn">작성하기</button></a>
				</div>
			</div>
		</section>
	</main>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>