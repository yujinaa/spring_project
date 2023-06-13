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
						<div id="delText">*예약 내역이 있는 경우 취소 후 탈퇴 가능합니다.</div>
						<label for="userId">아이디</label> <input type="text" id="userId"
							value="${successLoginUser}" name="id" readonly="readonly" />
						<!-- 
						<input
							type="text" name="email" id="delete-email" placeholder="이메일">
						 -->
						<label for="delete-pwd">비밀번호</label> <input type="password"
							name="pwd" id="delete-pwd" placeholder="비밀번호"> <input
							type="password" name="pwdCheck" id="delete-pwd-check"
							placeholder="비밀번호 확인">
					</div>
					<button type="button" id="withdrawal-btn">탈퇴하기</button>
				</form>
			</div>
		</div>
	</main>
	<c:import url="../include/footer.jsp" />
	<script src="../resources/js/deleteMember.js"></script>
	<script type="text/javascript">

	var result = "${msg}";
	if (result === "success") {
		alert('성공적으로 탈퇴되었습니다. 그동안 이용해 주셔서 감사합니다.');
	} else if (result === "fail") {
		alert('탈퇴할 수 없습니다. 입력 정보를 다시 확인해 주세요.')
	}
	</script>
</body>
</html>