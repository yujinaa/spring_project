<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

   function readURL(input) {//있는 그대로 써야하는 코드다. 바뀔코드가 없음.그대로 사용할것
      var file = input.files[0] //파일에 대한 정보
      console.log(file)
      if (file != '') {
         var reader = new FileReader();
         reader.readAsDataURL(file); //파일의 정보를 토대로 파일을 읽고 
         reader.onload = function (e) { // 파일 로드한 값을 표현한다
          //e : 이벤트 안에 result값이 파일의 정보(위치)를 가지고 있다.
	     console.log(e.target)
		console.log(e.target.result)
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

	<div class="row" >
		<div class="col-lg-12" ></div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12" style="height: 630px;" >
			<div class="panel panel-default" style="margin-top: 30px; height: 590px;">
				<div class="panel-heading">게시글 작성하기</div>
				<div class="panel-body">

					<form method="post" action="${contextPath}/board/writeSave" enctype="multipart/form-data">
						<div class="form-group">
							<label>작성자</label> <input class="form-control" name="writer" value="${successUser  }" readonly>
						</div>
						<div class="form-group">
							<label>제목</label> <input class="form-control" name="title">
						</div>

						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3" name="content"></textarea>
						</div>
						
					
						<div class="form-group" style="height: 150px; width: 200px;">
							<label>이미지 파일 첨부</label> <input type="file" name="imgFile" onchange="readURL(this);"/>
							 <img id="preview" src="#" width=200 height=150 alt="선택된 이미지가 없습니다" style="align-content: flex-end; ">
						</div>
				
						<input type="submit" class="btn btn-default" value="글 등록하기" style="margin-top: 50px;">
						<input type="button" class="btn btn-default" value="목록보기" 
								onClick="location.href='${contextPath}/board/list'" style="margin-top: 50px;">
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