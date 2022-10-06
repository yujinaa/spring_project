<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>

<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>후기작성</title>
<link rel="stylesheet" href="../resources/css/review-write.css">
</head>
<body>
	<div class="skip">
		<a href="#container">본문 바로 가기</a>
	</div>
	<c:import url="../include/header.jsp" />
<div class="modal fade" id="sampleModalPopup" role="dialog" tabindex="-1">
    <div class="modal-dialog modal-dialog-width1000 modal-dialog-height800">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
        </div>
        <div class="modal-body">
        </div>
        <div class="modal-footer">
            <button type="button"class="btn btn-color2" data-dismiss="modal" >닫기</button>
        </div>
    </div>
</div>
	<main id="container">
		<section class="review-write">
			<div class="page-title">
				<div class="container">
					<h2>후기작성</h2>
				</div>
			</div>

			<form action="${contextPath}/board/writeSave" method="post">
				<div class="review-space cf">
					<input type="text" name="writer" id="writer"
						value="${successLoginUser  }" readonly> <input type="text"
						name="title" id="title" placeholder="제목 입력">
					<textarea name="content" cols="30" rows="10" placeholder="내용 입력"></textarea>
					<button type="reset" id="cancel-btn">취소</button>
					<button type="submit" id="regist-btn">등록하기</button>
				</div>
			</form>

		</section>
	</main>
<script>
		$(document).ready(function() {
				        var result = '<c:out value ="${result}"/>';
				        checkModal(result);
				
						function checkModal(result) {
							if(result===''){
						return;
							}
							else{
				            $("#sampleModalPopup").modal("show"); 
								
							}}
				        });
</script>
	<c:import url="../include/footer.jsp" />
</body>
</html>