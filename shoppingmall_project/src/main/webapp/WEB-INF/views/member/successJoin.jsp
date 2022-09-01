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
joinMessage{
	margin: auto;
	width: 400px;
	height: 400px;
}
h3{
	margin-top: 100px;
}
.bottom{
	padding-top: 30px;
}
.button{
	padding-top: 60px;
}
.button input{
	background-color: black;
	color: white;
	cursor: pointer;
}
.button a:hover input {
	background:Silver;
	transition: all 0.5s;
	border: none;	
	
}

</style>
</head>
<body>
	<c:import url="../default/header.jsp"/>
		<div class="joinMessage" align="center">
				<div>
					<h3>회원가입이 완료 되었습니다.</h3>											
				</div>
				<div class="bottom">
					블랙업을 이용해 주셔서 대단히 감사합니다.<br>
					아래의 링크를 클릭하셔서 쿠폰팩을 확인해보세요!
				</div>
				<div class="button">
						<a href="#"><input type="button" value="쿠폰 확인하기" style="width: 180px; height: 50px;">	</a>			
						<a href="../index"><input type="button" value="홈으로 이동" style="width: 180px; height: 50px;"></a>			
				</div>
		</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>