<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bit Cinema</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="/assets/css/main.css"	rel="stylesheet" type="text/css">
</head>
<body class="w3-content" style="max-width:1200px; margin-top:18px">
	<script src="/assets/js/bootstrap.js"></script>
	<script src="/assets/js/jquery/jquery-1.9.0.js"></script>
	

	
	<!-- Sidebar/menu -->
	<c:import url='/WEB-INF/views/includes/coursecategorybar.jsp' />
	
	<div class="w3-main" style="margin-left:250px">
	
		<c:import url='/WEB-INF/views/includes/header.jsp' />
			<div id="board" style="margin-top:40px">
				<form id="search_form" action="/courseEvaluationBoard/list.do" method="post" style="text-align:center">
					<input type="text" id="search1" name="search" value="${search }">
					<input type="hidden" id="search2" name="movieName" value="${movieName }"> 
					<input type="submit" value="찾기">
				</form>

				<table class="table table-striped table-hover" style="margin-top:50px">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>영화명</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach items="${list }" var="vo" varStatus="status">
						<tr>
							<td>${count-status.index }</td>
							<td><a href="/courseEvaluationBoard/view/${vo.idx}.do">
								${vo.title }</a></td>
							<td>${vo.name }</td>
							<td>${vo.hit_Cnt }</td>
							<td>${vo.reg_Date }</td>
							<td>${vo.movieName }</td>
							<%-- <c:choose> 
									<c:when test="${!empty authUser && authUser.no == vo.user_Idx }"> --%>
									<td><a href="/courseEvaluationBoard/delete/${vo.idx}.do?movieName=${vo.movieName}"	class="del">삭제</a></td>
								<%-- </c:when>
								<c:otherwise>
									<td>&nbsp;</td>
								</c:otherwise>
							</c:choose> --%>
						</tr>
					</c:forEach>
				</table>

				<!-- pager 추가 -->
				<!-- 이전페이지/다음페이지를 추가하기 위해서 페이징체크처리 -->
				<!-- 미리 계산한 데이터를 map에 저장해서 내려주기 -->
				<div class="text-center">
					<ul class="pagination">
						<c:if test="${pageVo.nowPage > pageVo.cntPage/2 + 1 }">
							<li><a href="/courseEvaluationBoard/list.do?nowPage=1&search=${search }&movieName=${movieName }">◀</a></li>
						</c:if>
						<c:forEach begin="${pageVo.firstPageInCurrentPageGroup }" end="${pageVo.lastPageInCurrentPageGroup }" var="i" step="1">
							<c:choose>
								<c:when test="${i == pageVo.nowPage }">
									<li><a href="/courseEvaluationBoard/list.do?nowPage=${i}&search=${search }&movieName=${movieName }">${i }</a></li>	
								</c:when>
								<c:otherwise>
									<li><a href="/courseEvaluationBoard/list.do?nowPage=${i }&search=${search }&movieName=${movieName }">${i }</a></li>	
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pageVo.lastPage > 5 && pageVo.nowPage != pageVo.lastPage }">
							<li><a href="/courseEvaluationBoard/list.do?nowPage=${pageVo.lastPage}&search=${search }&movieName=${movieName }">▶</a></li>
						</c:if>
					</ul>
				</div>
				<!-- pager 추가 -->
				<%-- <c:if test="${!empty authUser }"> --%>
					<div class="bottom">
						<button type="button" class="btn btn-sm btn-primary" id="btnList" onclick='location.href="/courseEvaluationBoard/write/${movieName}.do"'>글쓰기</button>
					</div>
				<%-- </c:if> --%>
			</div>
		
	  <!-- End page content -->
	  </div>
	  
</body>
</html>