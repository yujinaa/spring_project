<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ include file="../include/header.jsp" %>
			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">게시판</h2>  
						<h4><c:if test="${successUser != null}">
							${successUser}님이 접속중입니다.
						</c:if></h4>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading" >게시글</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>조회수</th>
										<th>작성일자</th>
									</tr>
								</thead>
								<tbody>
								
								<c:forEach items="${boardList}" var="dto">
									<tr class="odd gradeX">
										<td>${dto.writeNum }</td>
										<td><a href="${contextPath }/board/writeView?writeNum=${dto.writeNum}"> ${dto.title }</a></td>
										<td>${dto.writer }</td>
										<td>${dto.hitNum }</td>
										<td>${dto.regDate }</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<!-- /.table-responsive -->
						</div>
						<div align="center">
							<c:forEach var = "num" begin="1" end="${repeat }">
								<a href="list?num=${num }">[${num }]</a>
							</c:forEach>
						</div>
							<a href="${contextPath }/board/write">
							<input type="button" value="글쓰기" class="btn btn-xs pull-right"  style= "font-size: 17px; "></a>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			
<%@ include file="../include/footer.jsp" %>