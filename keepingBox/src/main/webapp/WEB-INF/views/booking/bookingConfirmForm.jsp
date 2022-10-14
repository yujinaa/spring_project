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
<%=request.getAttribute("bookDateS")%>
<%=request.getParameter("bookDateS") %>
<%=request.getParameter("bookDateE") %>
<% String name = request.getParameter("name"); %>
<%=request.getParameter("size") %>
<%=request.getParameter("city") %>
<%=request.getParameter("price") %>


<%=name %>
<script type="text/javascript">
//		  $("#start-day").load("booking.jsp bookDateS"); 
</script>		
	
</body>
</html>