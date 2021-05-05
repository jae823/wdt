<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/include-header.jspf"%>
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
	<form id="frm" name="frm" enctype="multipart/form-data">
		<table class="table table-striped table-hover" style="margin-top:50px">
			<tr>
				<th colspan="2" style="text-align:center">영화 등록</th>
			</tr>
			<tr>
				<td style="padding:20px">카테고리 선택</td>
				<td style="padding:20px">
					<select class="category1" name="mvCateCode">
						<option value="100">전체</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="padding:20px">영화명</td>
				<td style="padding:20px">
					<input type="text" id="mvName" name="mvName" />
				</td>
			</tr>
			<tr>
				<td style="padding:20px">예매가격</td>
				<td style="padding:20px">
					<input type="text" id="mvPrice" name="mvPrice" />
				</td>
			</tr>
			<tr>
				<td style="padding:20px">전체좌석수</td>
				<td style="padding:20px">
					<input type="text" id="mvAvailSeat" name="mvAvailSeat" />
				</td>
			</tr>
			<tr>
				<td style="padding:20px">영화 설명</td>
				<td style="padding:20px">
					<textarea id="mvDes" name="mvDes"></textarea>
				</td>
			</tr>
			<tr>
				<td style="padding:20px">파일 추가</td>
				<td style="padding:20px">
					<div id="fileDiv">
						<p>
							<input type="file" id="file" name="file_0"> 
							<a href="#this" class="btn btn-sm btn-primary" id="delete" name="delete">삭제</a>
						</p>
					</div>
				</td>
			</tr>
		</table>
	<br/>
	<a href="#this" class="btn btn-sm btn-primary" id="addFile">파일 추가</a>
	<a href="#this" class="btn btn-sm btn-primary" id="write">등록</a> 
	</form>
		
	<!-- End page content -->
    </div>
		
		<script>

		var cate1Select = $('select.category1');
		var cate1Arr = [];
		var cate1Obj = {};
		var gfv_count = 1;
		
		$(document).ready(function() {
			$("#write").on("click", function(e) {
				//작성하기 버튼 
				e.preventDefault();
				fn_insertBoard();
			});
			$("#addFile").on("click", function(e) {
				//파일 추가 버튼
				e.preventDefault();
				fn_addFile();
			});
			$("a[name='delete']").on("click", function(e) {
				//삭제 버튼 
				e.preventDefault();
				fn_deleteFile($(this));
			});
		})
				
		function fn_insertBoard() {
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/courseEvaluationManagement/addCourse.do' />");
			comSubmit.submit();
		}
		function fn_addFile() {
			var str = "<p><input type='file' name='file_" + (gfv_count++)
					+ "'><a href='#this' class='btn' name='delete'>삭제</a></p>";
			$("#fileDiv").append(str);
			$("a[name='delete']").on("click", function(e) {
				//삭제 버튼 
				e.preventDefault();
				fn_deleteFile($(this));
			});
		}
		function fn_deleteFile(obj) {
			obj.parent().remove();
		}
		
		$(function() {
			$.ajax({
				url: "/courseEvaluationManagement/category",
				async: true,
				data: '',
				dataType: 'json',
				success: function(response) {
					if(response.result != 'success') {
						console.error(response.message);
						return;
					}
					
					if(response.data) {
						var data = response.data
						console.log(data);
						for(var i=0; i < data.length; i++) {
							if(data[i].cateCodeRef == 100) {
								cate1Obj = {};
								cate1Obj.cateCode = data[i].cateCode;
								cate1Obj.cateName = data[i].cateName;
								
								cate1Arr.push(cate1Obj);	
							}
						}
						
						console.log(cate1Arr);
						for(var i=0; i < cate1Arr.length; i++) {
							cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>" 
									+ cate1Arr[i].cateName + "</option>");	
						}
					}
					
					
				}, error : function(xhr, status, e) {
					console.log(status + ":" + e);
				}
			})
		})
		
		</script>
</body>
</html>
