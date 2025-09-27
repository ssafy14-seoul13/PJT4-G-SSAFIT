<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상 등록</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>영상 등록</h1>
	<form action="video" method="post">
		<input type="hidden" name="act" value="write"> <label for="id">영상
			ID:</label><br> <input type="text" id="id" name="id" required><br>
		<br> <label for="title">제목:</label><br> <input type="text"
			id="title" name="title" required><br>
		<br> <label for="part">부위:</label><br> <input type="text"
			id="part" name="part" required><br>
		<br> <label for="channelName">채널명:</label><br> <input
			type="text" id="channelName" name="channelName" required><br>
		<br> <label for="url">URL:</label><br> <input type="text"
			id="url" name="url" required><br>
		<br>

		<button type="submit">영상 등록</button>
	</form>
	<p>
		<a href="video?act=list">목록으로</a>
	</p>
</body>
</html>