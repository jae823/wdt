<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	
	<form id="form" method="post" action="/courseEvaluationBoard/update/${boardVo.idx}.do">
		<table class="table table-striped table-hover" style="margin-top:50px">
			<tr>
				<th colspan="2" style="text-align:center">글수정</th>
			</tr>
			<tr>
				<td style="padding:20px">제목</td>
				<td style="padding:20px"><input type="text" name="title" value="${boardVo.title }"></td>
			</tr>
			<tr>
				<td style="padding:20px">내용</td>
				<td style="padding:20px">
					<textarea id="content" name="content">${boardVo.content }</textarea>
				</td>
			</tr>
		</table>
		<div class="bottom">
			<button type="submit" class="btn btn-sm btn-primary" id="form">수정</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnList" onclick='location.href="/courseEvaluationBoard/view/${boardVo.idx}.do"'>취소</button>
		</div>
		<input type="hidden" id="movieName" name="movieName" value="${boardVo.movieName }">
	</form>				
	
	
  <!-- End page content -->
  </div>
</body>
</html>