<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bit Cinema</title>
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
	
		<table class="table table-striped table-hover" style="margin-top:50px">
				<thead>
					<tr>
						<th>썸네일</th>
						<th>이름</th>
						<th>카테고리</th>
						<th>가격</th>
						<th>전체 좌석수</th>
						<th>등록날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
					<tr>
						<td id='img'>
							<img src="/assets/upload/${list.stored_File_Name}" style="width:300px; height:400px"> 
						</td>
						<td>
							<a href="/courseEvaluationManagement/courseViewDetail/${list.mv_Idx}.do">${list.mvName}</a>
						</td>
						<td>
							${list.cateName}
						</td>
						<td>
							${list.mvPrice}
						</td>
						<td>${list.mvAvailSeat}</td>
						<td>
							<fmt:formatDate value="${list.mvDate}" pattern="yyyy-MM-dd" />
						</td>
					</tr>			
					</c:forEach>
				</tbody>
			</table>
			
	  <!-- End page content -->
	  </div>
			

</body>
</html>