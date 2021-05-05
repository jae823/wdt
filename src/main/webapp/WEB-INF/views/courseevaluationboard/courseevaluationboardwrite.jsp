<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bit Cinema</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="/assets/css/main.css"	rel="stylesheet" type="text/css">
</head>
<body class="w3-content" style="max-width:1200px; margin-top:18px;">

	<script src="/assets/js/bootstrap.js"></script>
	<script src="/assets/js/jquery/jquery-1.9.0.js"></script>

	<!-- Sidebar/menu -->
	<c:import url='/WEB-INF/views/includes/coursecategorybar.jsp' />
	
	<div class="w3-main" style="margin-left:250px">
	
	<c:import url='/WEB-INF/views/includes/header.jsp' />
	
	
	<div style="width:90%; margin-top:50px">
		<h2>글쓰기</h2>
		<form name="form" id="form" role="form" method="post" action="/courseEvaluationBoard/write.do">
			<div class="mb-3">
				<label for="title">제목</label>
				<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
			</div>

			<div class="mb-3">
				<label for="content">내용</label>
				<textarea class="form-control" rows="10" name="content" id="content" placeholder="내용을 입력해 주세요" ></textarea>
			</div>
			
			<div style="margin-top:50px">
				<button type="submit" class="btn btn-sm btn-primary" id="form">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList" onclick='location.href="/courseEvaluationBoard/list.do?movieName=${movieName }"'>목록</button>
			</div>
			<input type="hidden" name="movieName" value="${movieName }" />
		</form>
	</div>
		
	
	 <!-- End page content -->
	  </div>
</body>
</html>