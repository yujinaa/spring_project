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
<link rel="stylesheet" href="../resources/css/deleteMember.css">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../include/header.jsp" />
	<main id="container">
		<div class="withdrawal-box">
			<h2>회원탈퇴</h2>
			<div>
				<form id="withdrawalForm"
					action="${contextPath }/member/deleteMemberCheck" method="post">
					<div class="form-group">
						<input type="text" value="${successLoginUser}" name="id" /> <input
							type="password" name="pwd" id="pwd" placeholder="비밀번호">
					</div>
					<button type="button" id="withdrawal-btn">탈퇴하기</button>
				</form>
			</div>
		</div>
	</main>
	<c:import url="../include/footer.jsp" />
	<script src="../resources/js/deleteMember.js"></script>
</body>
</html>