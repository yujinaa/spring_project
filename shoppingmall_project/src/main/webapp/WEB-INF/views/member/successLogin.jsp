<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin: auto;
}
h2{
	margin-top: 50px;
	text-align: center;
}

</style>
</head>
<body>
	<c:import url="../default/header.jsp" />
	<h2>관리자${loginSuccessUser } 님환영합니다</h2>
	<c:import url="../default/footer.jsp" />
</body>
</html>