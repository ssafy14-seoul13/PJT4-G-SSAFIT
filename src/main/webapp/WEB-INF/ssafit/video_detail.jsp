<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.dto.VideoDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영상 상세 정보</title>
</head>
<body>
    <h1>영상 상세 정보</h1>
    <%
        VideoDTO video = (VideoDTO) request.getAttribute("video");
        if (video != null) {
    %>
    <form action="/video" method="post">
        <input type="hidden" name="videoId" value="<%= video.getId() %>">
        
        <label>영상 ID:</label>
        <%= video.getId() %><br><br>

        <label for="title">제목:</label><br>
        <input type="text" id="title" name="title" value="<%= video.getTitle() %>" required><br><br>
        
        <label for="part">부위:</label><br>
        <input type="text" id="part" name="part" value="<%= video.getPart() %>" required><br><br>
        
        <label for="channelName">채널명:</label><br>
        <input type="text" id="channelName" name="channelName" value="<%= video.getChannelName() %>" required><br><br>
        
        <label for="url">URL:</label><br>
        <input type="text" id="url" name="url" value="<%= video.getUrl() %>" required><br><br>

        <button type="submit" name="_method" value="put">수정하기</button>
    </form>
    
    <form action="/video" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="hidden" name="videoId" value="<%= video.getId() %>">
        <button type="submit">삭제하기</button>
    </form>
    <% } else { %>
    <p>영상 정보를 찾을 수 없습니다.</p>
    <% } %>
    <p><a href="/video/list">영상 목록으로</a></p>
</body>
</html>