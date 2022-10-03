<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="/resources/css/login.css">
<link rel="stylesheet"
	href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <title>로그인</title>
<body>
    <div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>

    <header>
        <div class="head-wrap">
            <h1><a href="${contextPath }/index"><img src="/resources/img/logo.png" alt="logo"></a></h1>
            <nav>
                <ul>
                    <li><a href="booking.html">예약하기</a></li>
                    <li><a href="#">이용후기</a></li>
                    <li><a href="${contextPath }/member/login">로그인</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main id="container">
        <div class="login-box">
          <h2>로그인</h2>
            <div>
                <form action="/root/member/user_check" method="post">
                    <div class="user-box">
                        <input type="text" name="id" id="id" required="">
                        <label for="id">아이디</label>
                    </div>
                    <div class="user-box">
                        <input type="password" name="pwd" id="pwd" required="" class="user-margin">
                        <label for="pwd">비밀번호</label>
                    </div>
                    <div class="save-find">
                        <input type="checkbox" name="autoLogin" class="check-box">아이디 저장
                        <ul class="find">
                            <li><a href="#">아이디찾기</a></li>
                            <li><a href="#">비밀번호찾기</a></li>
                        </ul>
                    </div>

                    <button type="submit" id="btn">로그인</button>
                    <ul class="member-join">
                        <li><a href="register_form">회원가입</a>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </main>
    <footer>
        <div class="cf">
            <ul class="footer-left">
                <li><span class="en">Keeping<br>Box</span></li>
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
<script src="/resources/js/main.js"></script>
</body>
</html>