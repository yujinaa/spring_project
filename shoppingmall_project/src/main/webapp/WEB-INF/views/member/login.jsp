<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0 auto;
}

.loginForm{
	padding-top : 100px;
}
.loginForm_bottom{
	margin-top: 20px;
	width: 300px;
}
</style>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:import url="../default/header.jsp" />
	<div class="loginForm" align="center">
		<div>
		<h3>Login Or Create An Account</h3>
		</div>
	<div  class="loginForm_bottom" align="center" >
		<form action="/root/member/user_check" method="post">
			<table>
				<tr style="width: 200px;">
					<td><input type="text" name="id" placeholder="ID" ></td>
				</tr>
				<tr style="width: 200px;">
					<td><input type="text" name="pw" placeholder="PW"></td>
				</tr>
				<tr>
					<td ><input type="submit" value="로그인" style="width: 200px; height: 50px;"></td>
					<td ><input type="button" value = "회원가입" style="width: 200px; height: 50px;"></td>
				</tr>
			</table>
		</form>
	</div>
	</div>
	<c:import url="../default/footer.jsp" />

</body>
</html>