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
<title>후기작성</title>
<link rel="stylesheet" href="../resources/css/review-write.css">
</head>
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>
	<c:import url="../include/header.jsp" />
	<main id="container">
		<section class="review-write">
			<div class="page-title">
				<div class="container">
					<h2>후기작성</h2>
				</div>
			</div>

			<form action="${contextPath}/board/writeSave" method="post">
				<div class="review-space cf">
					<label for="writer">작성자</label> <input type="text" name="writer"
						id="writer" value="${successLoginUser  }" readonly> <label
						for="title">제목</label> <input type="text" name="title" id="title"
						placeholder="제목을 작성해 주세요."> <label for="content">내용</label>
					<textarea name="content" id="reviewContent" cols="30" rows="10"
						placeholder="글을 작성해 주세요."></textarea>
					<button type="reset" id="cancel-btn">취소</button>
					<button type="submit" id="regist-btn">등록하기</button>
				</div>
			</form>
		</section>
	</main>
	<c:import url="../include/footer.jsp" />
	<script src="../resources/js/reviewWrite.js"></script>
</body>
</html>