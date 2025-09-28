<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, ssafit.model.dto.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상 상세 정보</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>영상 상세 정보</h1>

	<c:if test="${empty video}">
		<p>영상 정보를 찾을 수 없습니다.</p>
	</c:if>

	<c:if test="${not empty video}">
		<form action="video" method="post">
			<input type="hidden" name="act" value="update"> <input
				type="hidden" name="id" value="${video.id}"> <label>영상
				ID:</label> <span>${video.id}</span><br>
			<br> <label for="title">제목:</label><br> <input type="text"
				id="title" name="title" value="${video.title}" required><br>
			<br> <label for="part">부위:</label><br> <input type="text"
				id="part" name="part" value="${video.part}" required><br>
			<br> <label for="channelName">채널명:</label><br> <input
				type="text" id="channelName" name="channelName"
				value="${video.channelName}" required><br>
			<br> <label for="url">URL:</label><br> <input type="text"
				id="url" name="url" value="${video.url}" required><br>
			<br>

			<button type="submit">수정하기</button>
		</form>

		<hr>

		<form action="video" method="post">
			<input type="hidden" name="act" value="delete"> <input
				type="hidden" name="id" value="${video.id}">
			<button type="submit">삭제하기</button>
		</form>

		<hr>

		<!-- Review Section -->
		<h2>리뷰</h2>

		<!-- Review Write Form -->
		<c:if test="${not empty sessionScope.userId}">
			<form action="${pageContext.request.contextPath}/review" method="post">
				<input type="hidden" name="act" value="write">
				<input type="hidden" name="videoId" value="${video.id}">
				<label for="reviewContent">리뷰 작성:</label><br>
				<textarea id="reviewContent" name="content" rows="3" cols="50" required></textarea><br>
				<button type="submit">리뷰 등록</button>
			</form>
		</c:if>
		<c:if test="${empty sessionScope.userId}">
			<p>리뷰를 작성하려면 <a href="${pageContext.request.contextPath}/user?act=loginform">로그인</a>하세요.</p>
		</c:if>

		<br>

		<!-- Review List -->
		<c:choose>
			<c:when test="${not empty reviewList}">
				<c:forEach var="review" items="${reviewList}">
					<div>
						<strong>${review.userId}</strong> (${review.regDate})<br>
						<p>${review.content}</p>
						<c:if test="${sessionScope.userId eq review.userId}">
							<form action="${pageContext.request.contextPath}/review" method="post" style="display: inline;">
								<input type="hidden" name="act" value="delete">
								<input type="hidden" name="reviewId" value="${review.reviewId}">
								<input type="hidden" name="videoId" value="${video.id}">
								<button type="submit">삭제</button>
							</form>
							<!-- Note: A proper edit implementation would typically involve JavaScript or a separate page -->
						</c:if>
					</div>
					<hr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p>작성된 리뷰가 없습니다.</p>
			</c:otherwise>
		</c:choose>

	</c:if>

	<p>
		<a href="video?act=list">영상 목록으로</a>
	</p>
</body>
</html>