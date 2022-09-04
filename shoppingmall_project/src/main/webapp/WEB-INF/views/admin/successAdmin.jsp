<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2 {
	text-align: center;
}
.productplus li{
list-style: none;
}
.productplus li a{

display: flex;
}
</style>
</head>
<body>
	<c:import url="../default/header.jsp" />
	<div class="productplus">

		<ul>
			<li><c:if test="${loginSuccessUser !=null}">
					<a href="#">상품등록</a>
				</c:if></li>
		</ul>
	</div>
	<h2>${loginSuccessUser } 관리자님환영합니다</h2>
</body>
</html>