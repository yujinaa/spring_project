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
					<h2>내가 쓴 글</h2>
				</div>
			</div>
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
							<tbody >
								<c:forEach items="${myInfo.myPageList}" var="dto">
									<tr>
										<td>${dto.reviewNum }</td>
										<td><a
											href="${contextPath }/board/reviewDetail?reviewNum=${dto.reviewNum}">${dto.title }</a></td>
										<td>${dto.writer }</td>
										<td>${dto.regDate }</td>
										<td>${dto.hitNum }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<button type="button" id="moreView-btn" class="more">더보기</button>
					</div>
				</div>
		</section>
	</main>
	<c:import url="../include/footer.jsp" />
	
	<!-- 게시글 더보기 버튼 -->
	<script type="text/javascript">
		$(function() {
			$("tr").hide();
			$("tr").slice(0, 4).show(); // 초기갯수
			$("#moreView-btn").click(function(e) { // 더보기 버튼 클릭
				e.preventDefault();
				$("tr:hidden").slice(0, 4).show(); // 클릭시 리스트 갯수 지저정
				if ($("tr:hidden").length == 0) { // 컨텐츠 남아있는지 확인
					$("#moreView-btn").hide();  //더이상의 리스트가 없다면 버튼 사라짐
				}
			});
		});
	</script>

</body>
</html>