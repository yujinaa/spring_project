<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title></title>
<style type="text/css">
.login-user {
	margin-top: 10px;
}
</style>
<!-- Bootstrap Core CSS -->
<link href="/board/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/board/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="/board/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="/board/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/board/resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/board/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Talk Talk 게시판</a>
			</div>
			
			<c:choose>
				<c:when test="${successUser !=null }">
					<ul class="login-user" style="list-style: none; display: inline-block; font-size: 18px;">
						<li><a href="${contextPath }/member/logout" ><i class="fa fa-user fa-fw"></i> Logout</a></li>	
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="login-user" style="margin-left:90px;  list-style: none; display: inline-block; font-size: 18px;" >
								<li><a href="${contextPath }/member/login" ><i class="fa fa-user fa-fw"></i> Login</a></li>								
					</ul>				
				</c:otherwise>
			</c:choose>
					<c:if test="${successUser == null }">
						<ul class="signup-user" style="list-style: none; display: inline-block;font-size: 18px;">
							<li><a href="${contextPath }/member/signUp"><i class="fa fa-gear fa-fw"></i> SignUp</a></li>
						</ul> 					
					</c:if>
									
			<!-- 로그인페이지이동 -->	
				<!-- /.dropdown -->
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="${contextPath }/board/list"><i class="fa fa-dashboard fa-fw"></i>
								자유게시판</a></li>
						
						
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">