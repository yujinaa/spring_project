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
</head>
<body>
	<h1>회원탈퇴 페이지</h1>
	<div>
		<form action="${contextPath}/member/deleteMemberCheck" method="post"
			autocomplete="off" >
			<input type="text" value="${successLoginUser}" name="id" /> <input
				type="password" name="pwd" id="delPwd" placeholder="비밀번호">
			<button type="submit" id="deleteBtn">회원탈퇴</button>
		</form>
	</div>
	<script type="text/javascript">
		$("#deleteBtn").on("click", function(e) {
			if (confirm("정말 탈퇴?")) {
				alert('탈퇴성공');
				return true;					
				}else{
				alert('탈퇴실패');
				return false;					
				}
				}
		});
	</script>
</body>
</html>