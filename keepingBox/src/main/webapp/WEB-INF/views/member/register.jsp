<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
var idChk = 0;
function checkId(){
var id = $('#id').val(); //id값이 "inputId"인 입력란의 값을 저장
$.ajax({
    url:"idCheck", //Controller에서 요청 받을 주소
    type:"post", //POST 방식으로 전달
    data:id,
	dataType : "json", //서버로 돌려받는 값의 타입 지정
	//서버로 보낼 데이터 설정
	contentType : "application/json; charset=utf-8",

    success:function(data){ //컨트롤러에서 넘어온 cnt값을 받는다 
        if(data.cnt > 0){ 
        	alert("아이디가 존재합니다. 다른 아이디를 입력해 주세요");
            $('.chk-btn').addClass("has-error"); 
            $('.chk-btn').removeClass("has-success");
            $("#id").focus();
        } else {
        	alert("사용가능한 아이디입니다");
        	 $('.chk-btn').addClass("has-success"); 
             $('.chk-btn').removeClass("has-error");
             $("#inputPwd").focus();
             idChk=1;
        }
    },
    error:function(error){
        alert("아이디를 다시 입력해 주세요");
    }
});
};
</script> 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet" href="../resources/css/join.css">
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>

	<header>
		<div class="head-wrap">
			<h1>
				<a href="${contextPath }/index"><img src="/resources/img/logo.png" alt="logo"></a>
			</h1>
			<nav>
				<ul>
					<li><a href="booking.html">예약하기</a></li>
					<li><a href="#">이용후기</a></li>
					<c:choose>
                    	<c:when test="${successLoginUser !=null}">
                    		<li><a href="${contextPath }/member/logout">로그아웃</a></li>       
                    	</c:when>
                    	<c:otherwise>
		                    <li><a href="${contextPath }/member/login">로그인</a></li>                    	
                    	</c:otherwise>
                    </c:choose>
				</ul>
			</nav>
		</div>
	</header>

	<main id="container">
		<div class="login-box">
			<h2>회원가입</h2>
			<div>
				<form action="register" method="post">
					<label for="id">아이디</label> <input type="text" name="id" id="id"
						placeholder="4~12자의 영문 대소문자와 숫자만 입력">
					<button type="button" class="chk-btn" onclick="checkId()">중복확인</button>

					<label for="pwd">비밀번호</label> <input type="password" name="pwd"
						id="pwd" class="user-margin" placeholder="4~12자의 영문 대소문자와 숫자만 입력">

					<label for="pwdchk">비밀번호 확인</label> <input type="password" name="pwdchk" id="pwdchk"> 
					<label for="name">이름</label> <input type="text" name="name" id="name"> 
					<label for="phone">휴대폰 번호 (-없이)</label> <input type="tel" name="phone" id="phone"> 
					<label for="email">이메일</label> <input type="email" name="email"
						id="email" placeholder="example@gmail.com">
					<button type="button" class="chk-btn">전송하기</button>

					<button type="submit" onclick="register();" id="join-btn">회원가입</button>
					<!-- 나중에 type="submit"으로 해보기 -->
				</form>
			</div>
		</div>
	</main>
	<footer>
		<div class="cf">
			<ul class="footer-left">
				<li><span class="en">Keeping<br>Box
				</span></li>
				<li>(주)Keeping Box | 사업자등록번호: 123-45-67899 | 대표이사: 김김김</li>
				<li>주소: 서울특별시 마포구 아현동 백범로</li>
				<li>COPYRIGHTⓒ 2022 KEEPINGBOX KOREA INC. ALL RIGHTS RESERVED</li>
			</ul>
			<ul class="footer-right">
				<li>고객센터 1111-1111</li>
				<li>월~금 9:00~18:00 (공휴일 · 주말 휴무)</li>
			</ul>
		</div>
	</footer>
	
	<script src="../resources/js/join.js"></script>
</body>
</html>