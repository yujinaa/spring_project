<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- layer popup content -->
	<div class="layerPopup" id="layer_popup" style="visibility: visible;">
		<div class="layerBox">
			<h4 class="title">공지사항</h4>
			<div class="contBox">
				<div class="cont">
					<h3>SALE</h3>
					<h5>20% OFF</h5>
				</div>
			</div>
			<div class="popupLook">
				<button>자세히보기</button>
			</div>
			<div class="footer">
				<form name="pop_form">
					<div id="check">
						<input type="checkbox" value="checkbox" id='chkbox'> <label
							for="chkbox">&nbsp&nbsp오늘 하루동안 보지 않기</label>
					</div>
					<div id="close">
						<a href="javascript:closePop();">닫기</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>