<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFIT</title>
</head>
<body>
	<jsp:include page="WEB-INF/ssafit/header.jsp" />
	
	<h2>PJT4-G-SSAFIT</h2>
	
	<!-- 로그인 -->
	<a href=user?act=loginform>로그인</a>
	<br>
	<!-- 회원가입 -->
	<a href=user?act=writeform>회원가입</a>
	<br>
	<!-- 영상전체조회 -->
	<a href=video?act=list>운동 영상 전체 조회</a>
</body>
</html>