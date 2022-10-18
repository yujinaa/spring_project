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
	예약확인 페이지
	<input type="text" name="getTxt">
	<input type="text" name="userId" id="userId"
		value="${successLoginUser  }">



<script type="text/javascript">
//		  $("#start-day").load("booking.jsp bookDateS"); 
</script>		
	
</body>
</html>