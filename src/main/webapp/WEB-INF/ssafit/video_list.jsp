<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List, ssafit.model.dto.User"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상 목록</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>SSAFIT 영상 목록</h1>
	<p>
		<a href="video?act=writeform">새로운 영상 등록</a>
	</p>

	<c:if test="${empty list}">
		<p>등록된 영상이 없습니다.</p>
	</c:if>

	<c:if test="${not empty list}">
		<table border="1">
			<thead>
				<tr>
					<th>제목</th>
					<th>운동 부위</th>
					<th>채널명</th>
					<th>상세 보기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="video">
					<tr>
						<td>${video.title}</td>
						<td>${video.part}</td>
						<td>${video.channelName}</td>
						<td><a href="video?act=detail&id=${video.id}">상세</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<p>
		<a href="index.jsp">메인으로</a>
	</p>
</body>
</html>