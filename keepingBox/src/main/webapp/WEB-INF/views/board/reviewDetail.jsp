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
						<label for="">글번호</label> <input type="text" name="reviewNum"
							value="${detailReview.reviewNum  }" readonly> <label
							for="">작성자</label> <input type="text" name="writer"
							value="${detailReview.writer  }" readonly>
					</div>
					<div class="title-content">
						<label for="">제목</label> <input type="text" name="title"
							value="${detailReview.title }" readonly> <label for="">내용</label>
						<textarea id="" name="content" readonly="readonly" cols="30"
							rows="10">${detailReview.content }</textarea>
					</div>
					<button type="button" id="List-btn"
						onClick="location.href='${contextPath}/board/review'">목록</button>
					<c:choose>
						<c:when test="${successLoginUser == detailReview.writer  }">
							<button type="button" id="modify_btn"
								onclick="location.href='${contextPath }/board/modify_form?reviewNum=${detailReview.reviewNum }'">수정</button>
							<button type="button" id="delete_btn"
								onclick="location.href='${contextPath }/board/delete?reviewNum=${detailReview.reviewNum }'">삭제</button>
						</c:when>

					</c:choose>
				</div>
			</div>
		</section>
	</main>
	<c:import url="../include/footer.jsp" />
	<script type="text/javascript">
		$("#delete_btn").on("click", function(e) {
			alert('삭제하시겠습니까?');
		});
	</script>
	<!-- 
	
	<script>
		$(document).ready(function() {

			let result = '<c:out value="${result}"/>';
			checkAlert(result);
			function checkAlert(result) {
				if (result === '') {
					return;
				}
				if (result === "savesuccess") {
					alert("등록이 완료되었습니다.");
				}
				if (result === "delsuccess") {
					alert("삭제가 완료되었습니다.");
				}
			}
		});
	</script>
	 -->
</body>
</html>