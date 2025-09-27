<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, ssafit.model.dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상 상세 정보</title>
</head>
<body>
    <h1>영상 상세 정보</h1>
    
    <c:if test="${empty video}">
        <p>영상 정보를 찾을 수 없습니다.</p>
    </c:if>

    <c:if test="${not empty video}">
        <form action="video" method="post">
            <input type="hidden" name="act" value="update">
            <input type="hidden" name="id" value="${video.id}">
            
            <label>영상 ID:</label>
            <span>${video.id}</span><br><br>

            <label for="title">제목:</label><br>
            <input type="text" id="title" name="title" value="${video.title}" required><br><br>
            
            <label for="part">부위:</label><br>
            <input type="text" id="part" name="part" value="${video.part}" required><br><br>
            
            <label for="channelName">채널명:</label><br>
            <input type="text" id="channelName" name="channelName" value="${video.channelName}" required><br><br>
            
            <label for="url">URL:</label><br>
            <input type="text" id="url" name="url" value="${video.url}" required><br><br>

            <button type="submit">수정하기</button>
        </form>
        
        <hr>
        
        <form action="video" method="post">
            <input type="hidden" name="act" value="delete">
            <input type="hidden" name="id" value="${video.id}">
            <button type="submit">삭제하기</button>
        </form>
    </c:if>
    
    <p><a href="video?act=list">영상 목록으로</a></p>
</body>
</html>