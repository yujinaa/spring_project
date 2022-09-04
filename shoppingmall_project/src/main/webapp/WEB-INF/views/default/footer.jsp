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
.footer_top{
	text-align: right;
}
.footer_top li{
	list-style: none;
}
.footer_bottom{
}

.footer_bottom li{
	list-style: none;
}
.footer_left{
	float : left;
	text-align: left;
}

.footer_right{
	float : right;
	text-align: right;
}
.adminstrator button{
	width: 10px;
	height: 40px;
}
.btn{
	visibility: hidden;
}
</style>
</head>
<body>
<div style="padding-top:350px;">
<hr>
<div class="footer_top">
<ul>
	<li>AGREEMENT | SHOPPING GUIDE | PRIVACY</li>
</ul>
</div>
<div class="footer_bottom">
<div class="footer_left">
	<div>
	<ul>
		<li>
			도움말 | 배송 | 교환/반품/환불 | 인재채용 | 제휴문의
		</li>
	</ul>
	</div>
	<div>
	<c:choose>
		<c:when test="${loginSuccessUser != null }">
			<button class="btn" >administrator</button>
		</c:when>
		<c:otherwise>
			<button class="administrator" onclick="location='${contextPath}/admin/admin_login'">administrator</button>
		</c:otherwise>
	</c:choose>
	</div>
</div>

<div class="footer_right">
	<ul>
		<li>COMPANY:(주)블랙업 | OWNER:최예나래 | TEL:1566-6813 | EMAIL:contact@black-up.co.kr | BUSINESS LICENSE:419-87-00807<br>
			| E-COMMERCE PERMIT:제 2017-서울마포-2273호 | ADDRESS: 03992  서울특별시 마포구 동교로23길 32-22 (동교동)JC동교빌딩 4층</li>
	</ul>
</div>
</div>
</div>
</body>
</html>