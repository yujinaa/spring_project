<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ include file="../include/header.jsp"%>

<body>
	<!-- Bootstrap Core CSS -->
	<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- MetisMenu CSS -->
	<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

	<!-- Custom Fonts -->
	<link href="../vendor/font-awesome/css/font-awesome.min.css"
		rel="stylesheet" type="text/css">
	<div class="row">
		<div class="col-lg-12"></div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12" >
			<div class="panel panel-default" style="margin-top: 30px; ">
				<div class="panel-heading">게시글 작성하기</div>
				<div class="panel-body">

					<form role="form">
						<div class="form-group">
							<label>작성자</label> <input class="form-control" name="writer">
						</div>
						<div class="form-group">
							<label>제목</label> <input class="form-control" name="title">
						</div>

						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3"></textarea>
						</div>
						<div class="form-group">
							<label>이미지 파일 첨부</label> <input type="file">
						</div>

						<button type="submit" class="btn btn-default">Submit
							Button</button>
						<button type="reset" class="btn btn-default">Reset Button</button>
					</form>
				</div>

			</div>
			<!-- /.col-lg-6 (nested) -->
		</div>
		<!-- /.row (nested) -->
	</div>
	<!-- /.panel-body -->


	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>
</body>
</html>