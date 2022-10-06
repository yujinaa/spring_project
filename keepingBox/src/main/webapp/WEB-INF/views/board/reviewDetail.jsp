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
<title>이용후기</title>
<link rel="stylesheet" href="../resources/css/review-detail.css">
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>
	<c:import url="../include/header.jsp" />
	<main id="container">
		<section class="review-write">
			<div class="page-title">
				<div class="container">
					<h2>이용후기</h2>
				</div>
			</div>
			<div class="review-space cf">
				<label>글번호</label> <input class="form-control" name="reviewNum"
					value="${detailReview.reviewNum  }" readonly> <label>작성자</label>
				<input class="form-control" name="writer"
					value="${detailReview.writer  }" readonly> <label>제목</label>
				<input class="form-control" name="title"
					value="${detailReview.title }" readonly> <label>내용</label>
				<textarea class="form-control" rows="3" name="content"
					readonly="readonly">${detailReview.content }</textarea>
				<button type="button" id="List-btn"
					onClick="location.href='${contextPath}/board/review'">목록</button>
			</div>
		</section>
	</main>
	<c:import url="../include/footer.jsp" />
</body>
</html>