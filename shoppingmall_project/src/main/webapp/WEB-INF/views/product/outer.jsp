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
* {
	margin: 0 auto;
}

header {
	margin-top: 30px;
	height: 40px;
}

nav {
	height: 40px;
}

.detail_category ul li {
	display: inline-block;
}

.best_product {
	height: 400px;
	border: solid 1px blue;
}

#product_list_box {
	margin-top: 80px;
	width: 1500px;
	min-height: 800px;
	border: 1px solid green;
	
}
#product_list_box table{
	border: 1px solid green;
	width: 370px;
}
.image{
	height: 500px;
}




</style>
</head>
<body>
	<c:import url="../default/header.jsp" />

	<header>
		<div class="category" style="text-align: center;">아우터</div>
	</header>

	<nav>
		<div class="detail_category" style="text-align: center;">
			<ul>
				<li><a href="#">가디건/집업</a></li>
				<li><a href="#">자켓/베스트</a></li>
				<li><a href="#">점퍼</a></li>
				<li><a href="#">코트</a></li>
			</ul>
		</div>
	</nav>
	<section>


		<div class="best_product"></div>


	</section>

<!-- 상품목록 -->
	<section>
		<div id="product_list_box">
			<table border="1">
				
				<tr class="image">
					<td><a href="#">사진</a></td>
				</tr>
				<tr class="name">
					<td>이름</td>
				</tr>
				<tr class="price">
					<td>가격</td>
				</tr>
			</table>

		</div>
	</section>
	<div class="product_list_paging"></div>
	<c:import url="../default/footer.jsp" />
</body>
</html>