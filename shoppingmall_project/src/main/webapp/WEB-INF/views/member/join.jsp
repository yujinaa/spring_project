<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.registerTable{
		margin-top: 100px;
	}
</style>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../default/header.jsp"/>
<div align="center">
   <form action="register" method="post">
   	<h3>Create An Account</h3>
   	
      <table class="registerTable">
         <tr><td>
            <input type="text" name="id" placeholder="아이디* (영문소문지/숫자, 4~16자)"><br>
            <input type="password" name="pw" placeholder="비밀번호* (영문 대소문지/숫자/특수문자 중 2가지 이상 조합, 8자~16자)"><br>
            <input type="password" name="pw" placeholder="비밀번호 확인*"><br>
            <input type="text" name="name" placeholder="이름*"><br>
            <input type="tel" name="name" placeholder="휴대전화*"><br>
            <input type="email" name="name" placeholder="이메일*"><br>
            
            <input type="submit" value="회원가입">
         </td></tr>
      </table>
   </form>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>