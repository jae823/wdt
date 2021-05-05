<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bit Cinema</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/main.css"	rel="stylesheet" type="text/css">
</head>

<body class="w3-content" style="max-width:1200px">

<!-- Sidebar/menu -->
<c:import url='/WEB-INF/views/includes/coursecategorybar.jsp'/>


<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

  
  <!-- Top header -->
  <c:import url='/WEB-INF/views/includes/header.jsp'/>
 

  <!-- Image header -->
  <div class="w3-display-container w3-container">
  	<a href="/courseEvaluationBoard/list.do?movieName=${list[0].mvName}">
    <img src="/assets/upload/${list[0].stored_File_Name}" alt="${list[0].mvName }" style="width:100%">
    </a>
    <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
      <c:if test="${!categoryFlag }">
	      <h1 class="w3-jumbo w3-hide-small">Box Office</h1>
	      <h1 class="w3-hide-large w3-hide-medium">Box Office</h1>
	      <h1 class="w3-hide-small">Top 1</h1>
      </c:if>
      <!-- <p><a href="#jeans" class="w3-button w3-black w3-padding-large w3-large">예약하기</a></p> -->
    </div>
  </div>

  <div class="w3-container w3-text-grey" id="jeans">
    <p>Top8 Movies</p>
  </div>

  <!-- Product grid -->
  <div class="w3-row w3-grayscale">
	  <c:forEach items="${list }" begin="1" var="movieVo" varStatus="status">
	 	<c:if test="${status.count mod 2 == 1 }">
	  		<div class="w3-col l3 s6">
	  	</c:if> 
		  	<div class="w3-container">
		  		<a href="/courseEvaluationBoard/list.do?movieName=${movieVo.mvName}">
		        <img src="/assets/upload/${movieVo.stored_File_Name}" style="width:100%">
		        </a>
		        <p>${movieVo.mvName }<br><b>${movieVo.mvPrice }</b></p>
		    </div>
	 	<c:if test="${status.count mod 2 == 0}">
	  		</div>
	  	</c:if> 
	  </c:forEach>
  </div>


  <!-- End page content -->
  </div>
  
</body>
</html>
