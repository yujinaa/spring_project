<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<body>
	<div class="row">
		<div class="col-lg-12"></div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12" style="height: 650px;">
			<div class="panel panel-default"
				style="margin-top: 30px; height: 600px;">
				<div class="panel-heading">게시글 조회하기</div>
				<div class="panel-body">
						
						<div class="form-group">
							<label>글번호</label> <input class="form-control" name="writeNum"
								value="${detailWriteData.writeNum  }" readonly>
						</div>
						
						<div class="form-group">
							<label>작성자</label> <input class="form-control" name="writer"
								value="${detailWriteData.writer  }" readonly>
						</div>
						<div class="form-group">
							<label>제목</label> <input class="form-control" name="title"
							  value="${detailWriteData.title }" readonly>
						</div>

						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3" name="content" readonly="readonly">${detailWriteData.content }</textarea>
						</div>
						
						<div class="form-group">
							<img width="200px" height="200px" style="display: block; margin: 0 auto;">${detailWriteData.imgFile }							  
						</div>



						<input type="button" class="btn btn-default" value="수정하기"
							> 
						<input type="button" class="btn btn-default" value="목록보기"
							onClick="location.href='${contextPath}/board/list'"
							>

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