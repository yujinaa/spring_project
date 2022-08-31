<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table{
	margin: 0 auto;
	padding: 20px;
	width: 600px;
}
.join_content input{
	width: 600px;
	height:30px;
	margin-top: 20px;

}
.phone_content select{
	width: 90px;
	height: 35px;
}
.phone_content input{
	width: 504px;
}

.join_button input{
	width: 608px;
	height: 50px;
	background-color:black;
	color: white; 
}

h3{
	margin-top: 100px;
}

</style>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../default/header.jsp" />
	<div class="table" align="center">
				<h3>Create An Account</h3>							
		<form action="join" method="post">
			<table>
				<tr>
					<td>
						<div> 
							<input type="radio" checked="checked">개인회원<br><br>					
							INFORMATION &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;*필수입력사항<br><br>
						</div>
						<div class="join_content">
							<input type="text" name="id" placeholder="아이디* (영문소문자/숫자,4~16자)"><br>
							<input type="password" placeholder="비밀번호*"><br>
							<input type="password" name="pw" placeholder="비밀번호 확인*"><br>
							<input type="text" name="name" placeholder="이름*"><br>
							<div class="phone_content">
							
							<!-- 
								<select name="phone_front">
									<option value = "p0">010
									<option value = "p1">011
									<option value = "p2">016
									<option value = "p3">017
									<option value = "p4">018
									<option value = "p5">019
								</select>
							
							 -->
								<input type="text" name="phone" placeholder="휴대전화*"><br>
							</div>
							<input type="email" name="email" placeholder="이메일*"><br>
							<div class="join_button">
								<input type="submit" value="회원가입">							
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<c:import url="../default/footer.jsp" />

</body>
</html>