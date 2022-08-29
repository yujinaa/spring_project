<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:import url="../default/header.jsp" />
		<div align="center">
		<h3>Login Or Create An Account</h3>
	</div>
	<div align="center">
		<form action="/root/member/user_check" method="post">
			<table>
				<tr>
					<td><input type="text" name="id" placeholder="ID"></td>
				</tr>
				<tr>
					<td><input type="text" name="pw" placeholder="PW"></td>
				</tr>
				<tr>
					<td><input type="submit" value="로그인" style="width: 150px; height: 50px;"></td>
					<td colspan="2" align="left"><button style="width: 150px; height: 50px;">회원가입</button></td>
				</tr>
			</table>
		</form>
	</div>
	<c:import url="../default/footer.jsp" />

</body>
</html>