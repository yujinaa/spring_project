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
<link rel="stylesheet" href="../resources/css/modify-form.css">
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
					<form action="${contextPath}/board/modifySave" method="post">
						<div class="num-writer">
							<label>글번호</label> <input class="form-control" name="noticeNum"
								value="${detailNotice.noticeNum  }" readonly> <label>작성자</label>
							<input class="form-control" name="writer"
								value="${detailNotice.writer  }" readonly>
						</div>
						<div class="title-content">
							<label>제목</label> <input type="text" name="title"
								value="${detailNotice.title }"> <label>내용</label>
							<textarea id="" name="content" cols="30" rows="10">${detailNotice.content }</textarea>
						</div>
						<button type="button" id="List-btn"
							onClick="location.href='${contextPath}/board/notice'">목록</button>
						<!-- 본인 작성글에서만 수정,삭제하기 버튼 뜨고 본인 글이 아니라면 댓글작성만 뜨기 -->
						<c:if test="${successLoginUser == detailNotice.writer  }">
							<input type="submit" id="modify_btn" value="수정">
							<input type="submit" id="delete_btn" value="삭제">
						</c:if>
					</form>
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
	<script type="text/javascript">
		$("#modify_btn").on("click", function(e) {
			if (e.value != "0") {
				alert("수정되었습니다.");
			}
		});
	</script>
</body>
</html>