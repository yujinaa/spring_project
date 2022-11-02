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
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/myInfoModify.css">
</head>
<c:import url="../include/header.jsp" />
<main id="container">
	<div class="modify">
		<h2>회원정보수정</h2>
		<div>
			<form action="${contextPath}/member/modifySave" method="post">
				<label for="id">아이디</label> <input type="text" name="id" id="id"
					value="${info.id }" readonly> <label for="pwd">비밀번호</label>
				<input type="password" name="pwd" id="pwd" class="user-margin"
					placeholder="4~12자의 영문 대소문자와 숫자만 입력"><label for="name">이름</label>
				<input type="text" name="name" id="name"> <label for="phone">휴대폰
					번호 (-없이)</label> <input type="tel" name="phone" id="phone"> <label
					for="email">이메일</label> <input type="email" name="email" id="email">
				<button type="submit" id="save-btn">변경 내용
					저장</button>
			</form>
		</div>
	</div>
</main>
<c:import url="../include/footer.jsp" />
<!-- 
<script type="text/javascript">
		$("#save-btn").on("click", function(e) {
			if (confirm("정보를 수정하시겠습니까?")) {
				alert('수정되었습니다.');
				return true;
			} else {
				alert('정보를 수정할 수 없습니다.');
				return false;
			}
		});
</script>	
 -->
<script src="../resources/js/mypage-modify.js"></script>
</body>
</html>