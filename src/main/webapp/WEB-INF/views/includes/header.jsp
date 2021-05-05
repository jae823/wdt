<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<style>
	#loginlist li {
		display: inline;
		list-style-type : none;
		float: right;
		margin-left: 10px;
		font-size: 18px;
	}
	
	#loginlist a {
		text-decoration:none;
		font-size:15px;
	}
</style>

  <header class="w3-container w3-xlarge">
    <p class="w3-left">Movie Review Site</p>
   	 <p class="w3-right">
		<ul id ="loginlist">
<%-- 			<c:choose>
				<c:when test='${empty authUser}'>
					<li><a href="${pageContext.request.contextPath}/user/login">로그인</a><li>
					<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a><li>
				</c:when>
				<c:otherwise>
					<li>${authUser.name }님 안녕하세요</li>
					<li><a href="${pageContext.request.contextPath}/user/update">회원정보수정</a><li>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>	<li>
				</c:otherwise>
			</c:choose>
			<c:if test='${admin eq "admin" }'>
					<li><a href="${pageContext.request.contextPath}/courseEvaluationManagement/getCourseList.do">영화 목록</a></li>
					<li><a href="${pageContext.request.contextPath}/courseEvaluationManagement/addCourse.do">영화 추가</a></li>
			</c:if>
		</ul> --%>
    </p>
  </header>