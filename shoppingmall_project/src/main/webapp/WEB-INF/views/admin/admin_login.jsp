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
*{
	margin:0  auto;
}
.admin_login_table{
	padding-top: 100px;
	}
 table {
	padding-top: 50px;
}
</style>
</head>
<body>
<div>
	<div  class="admin_login_table" align="center" >
	<h1>관리자 로그인</h1>
		<form action="/root/admin/admin_check" method="post">
			<table>
				<tr style="width: 500px; height: 50px;">
					<td><input type="text" name="id" placeholder="ID" ></td>
				</tr>
				<tr style="width: 500px;  height: 50px;">
					<td><input type="text" name="pw" placeholder="PW"></td>
				</tr>
				<tr>
					<td >
						<input type="submit" value="로그인" style="width: 200px; height: 50px;">
					<a href="#"><input type="button" value = "회원가입" style="width: 200px; height: 50px;"></a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>