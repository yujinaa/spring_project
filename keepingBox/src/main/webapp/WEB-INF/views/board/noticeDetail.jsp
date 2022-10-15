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
				<div id="review-form">
					<div class="num-writer">
						<label for="">글번호</label> <input type="text" name="noticeNum"
							value="${detailNotice.noticeNum  }" readonly> <label
							for="">작성자</label> <input type="text" name="writer"
							value="${detailNotice.writer  }" readonly>
					</div>
					<div class="title-content">
						<label for="">제목</label> <input type="text" name="title"
							value="${detailNotice.title }" readonly> <label for="">내용</label>
						<textarea id="" name="content" cols="30"
							rows="10" readonly>${detailNotice.content }</textarea>
					</div>
					<button type="button" id="List-btn"
						onClick="location.href='${contextPath}/board/notice'">목록</button>
					<c:choose>
						<c:when test="${successLoginUser == detailNotice.writer  }">
							<button type="button" id="modify_btn"
								onclick="location.href='${contextPath }/board/noticeModify?noticeNum=${detailNotice.noticeNum }'">수정</button>
							<button type="button" id="delete_btn"
								onclick="location.href='${contextPath }/board/noticedelete?noticeNum=${detailNotice.noticeNum }'">삭제</button>
						</c:when>

					</c:choose>
				</div>
			</div>
		</section>
	</main>
	<c:import url="../include/footer.jsp" />
</body>
</html>