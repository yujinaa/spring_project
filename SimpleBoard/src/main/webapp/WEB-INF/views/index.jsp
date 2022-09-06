<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<style type="text/css">
</style>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<title></title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="main.jsp">Talk Talk</a>
  <a class="navbar-brand text-secondary" href="main.jsp">메뉴</a>
  <a class="navbar-brand text-secondary" href="bbs.jsp">게시판</a>
  <div class="dropdown">
   <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" 
           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >My Account
   </button>
   <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="login.jsp">로그인</a>
    <a class="dropdown-item" href="join.jsp">회원가입</a>
   </div>
  </div>
 </nav>
</body>
</html>

