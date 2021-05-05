<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="/assets/css/main.css"	rel="stylesheet" type="text/css">
<style>
	select { width: 100px; }
	input { width:150px; }
	.select_img img { margin:20px 0;}
</style>
</head>
<body class="w3-content" style="max-width:1200px; margin-top:18px">
	<script src="/assets/js/bootstrap.js"></script>
	<script src="/assets/js/jquery/jquery-1.9.0.js"></script>
	
	<!-- Sidebar/menu -->
	<c:import url='/WEB-INF/views/includes/coursecategorybar.jsp' />
	
	<div class="w3-main" style="margin-left:250px">

	<c:import url='/WEB-INF/views/includes/header.jsp' />
		
	<form id="form" name="form" method="post">	
		<table class="table table-striped table-hover" style="margin-top:50px">
			<tr>
				<th colspan="2" style="text-align:center">등록 영화 조회</th>
			</tr>
			<tr>
				<td style="padding:20px">카테고리</td>
				<td style="padding:20px">
					${movieVo.cateName }
				</td>
			</tr>
			<tr>
				<td style="padding:20px">영화명</td>
				<td style="padding:20px">
					${movieVo.mvName }
				</td>
			</tr>
			<tr>
				<td style="padding:20px">예매가격</td>
				<td style="padding:20px">
					${movieVo.mvPrice }
				</td>
			</tr>
			<tr>
				<td style="padding:20px">전체좌석수</td>
				<td style="padding:20px">
					${movieVo.mvAvailSeat }
				</td>
			</tr>
			<tr>
				<td style="padding:20px">영화 설명</td>
				<td style="padding:20px">
					${movieVo.mvDes }
				</td>
			</tr>
			<tr>
				<td style="padding:20px">영화 포스터 이미지</td>
				<td style="padding:20px">
					<img src="/assets/upload/${movieVo.stored_File_Name}" style="width:300px; height:400px">
				</td>
			</tr>	
		</table>
	</form>
	
	<!-- End page content -->
    </div>
</body>
</html>
