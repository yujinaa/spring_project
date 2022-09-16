<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../resources/dist/css/sb-admin-2.css" rel="stylesheet">


<!-- Custom Fonts -->
<link href="../resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	
<!-- modal -->
<link href="../resources/vendor/replyModal/modal.css" rel="stylesheet" type="text/css">
<body>
	<div id="modal_wrap">     <!-- 모달 추가 -->
		<div id="first">
			<div style="width: 250px; margin: 0 auto; padding-top: 20px;">
				<form id="frm">
					<input type="hidden" name="write_num"
						value="${detailWriteData.writeNum}"> <b>댓글달기</b>
					<hr>
					<b>작성자 : ${successUser}</b>
					<hr>
					<b>제목</b><br>
					<input type="text" id="title" size="30" name="title">
					<hr>
					<b>내용</b><br>
					<textarea name="replyContent" id="content" rows="9" cols="30"></textarea>
					<hr>
					<button type="button" onclick="reply()">댓글달기</button>
					<button type="button" onclick="slide_hide()">취소</button>
				</form>
			</div>
		</div>
</div>


	<div class="row">
		<div class="col-lg-12"></div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12" style="height: 690px;">
			<div class="panel panel-default"
				style="margin-top: 30px; height: 650px;">
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
						<textarea class="form-control" rows="3" name="content"
							readonly="readonly">${detailWriteData.content }</textarea>
					</div>

					<div class="form-group">
					<!-- 이미지 등록 유무에 따라 불러오기 처리 -->
					<c:choose>
						<c:when test="${ detailWriteData.imgFile == 'nan' }">
							<b>이미지가 없습니다</b>
						</c:when>
						<c:otherwise>
							<img name="imgFile" width="200px" height="200px"
								style="display: block; margin: 0 auto;"
								src="${contextPath}/board/imageView?imgFile=${detailWriteData.imgFile}">
						</c:otherwise>
					</c:choose>
					</div>
					<!-- 본인 작성글에서만 수정,삭제하기 버튼 뜨고 본인 글이 아니라면 댓글작성만 뜨기 -->
					<c:choose>
						<c:when test="${successUser == detailWriteData.writer  }">
							<input type="button" class="btn btn-default" 
							onclick="location.href='${contextPath }/board/modify_form?writeNum=${detailWriteData.writeNum }'" value="수정하기">
							<input type="button" class="btn btn-default" 
							onclick="location.href='${contextPath }/board/delete?writeNum=${detailWriteData.writeNum }&imgFile=${detailWriteData.imgFile}'" 
							value="삭제하기">
							<input type="button" class="btn btn-default" value="목록보기"
								onClick="location.href='${contextPath}/board/list'">
						</c:when>
						<c:otherwise>
							<input type="button"  onclick="slideClick()" class="btn btn-default" value="댓글작성">
							<input type="button" class="btn btn-default" value="목록보기"
								onClick="location.href='${contextPath}/board/list'">
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<!-- /.col-lg-6 (nested) -->
		</div>
		<!-- /.row (nested) -->
	</div>
	<!-- /.panel-body -->


	<!-- jQuery -->
	<script src="../resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../resources/dist/js/sb-admin-2.js"></script>
	<!-- 모달js -->
	<script src="../resources/dist/js/modal.js"></script>
</body>
</html>