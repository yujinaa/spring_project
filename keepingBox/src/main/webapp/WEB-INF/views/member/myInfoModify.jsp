<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<main id="container">
	<div class="modify">
		<h2>회원정보수정</h2>
		<div>
			<form name="member" method="post">
				<label for="id">아이디</label> <input type="text" name="id" id="id"
					readonly> <label for="pwd">비밀번호</label> <input
					type="password" name="pwd" id="pwd" class="user-margin"
					placeholder="4~12자의 영문 대소문자와 숫자만 입력"> <label for="pwdchk">비밀번호
					확인</label> <input type="password" name="pwdchk" id="pwdchk"> <label
					for="name">이름</label> <input type="text" name="name" id="name">

				<label for="phone">휴대폰 번호 (-없이)</label> <input type="tel"
					name="phone" id="phone"> <label for="email">이메일</label> <input
					type="email" name="email" id="email">

				<button type="submit" onclick="save();" id="save-btn">변경 내용
					저장</button>
			</form>
		</div>
	</div>
</main>
</body>
</html>