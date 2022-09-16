<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   function readURL(input) {
      var file = input.files[0] //파일에 대한 정보
      console.log(file)
      if (file != '') {
         var reader = new FileReader();
         reader.readAsDataURL(file); //파일의 정보를 토대로 파일을 읽고 
         reader.onload = function (e) { // 파일 로드한 값을 표현한다
          //e : 이벤트 안에 result값이 파일의 정보를 가지고 있다.
           $('#preview').attr('src', e.target.result);
          }
      }
  }  
   </script>
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
		<div class="col-lg-12" style="height: 690px;">
			<div class="panel panel-default"
				style="margin-top: 30px; height: 650px;">
				<div class="panel-heading">게시글 수정하기</div>
				<div class="panel-body">

				<form action="${contextPath}/board/modify" enctype="multipart/form-data" method="post" >
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
							value="${detailWriteData.title }" >
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="3" name="content">${detailWriteData.content }</textarea>
					</div>
					<div class="form-group">
						<input type="file" name="imgFile" onchange="readURL(this)">
						<c:if test="${ detailWriteData.imgFile != 'nan' }">
							<img name="imgFile" width=200px; height=200px; id="preview" style="display: block; margin: 0 auto;"
								src="${contextPath}/board/imageView?imgFile=${detailWriteData.imgFile}">
						</c:if>
					</div>
					<!-- 본인 작성글에서만 수정,삭제하기 버튼 뜨고 본인 글이 아니라면 댓글작성만 뜨기 -->
						<c:if test="${successUser == detailWriteData.writer  }">
							<input type="submit" class="btn btn-default" value="수정하기">
							<input type="submit" class="btn btn-default" value="삭제하기">
							<input type="button" class="btn btn-default" value="목록보기"
								onClick="location.href='${contextPath}/board/list'">
						</c:if>
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