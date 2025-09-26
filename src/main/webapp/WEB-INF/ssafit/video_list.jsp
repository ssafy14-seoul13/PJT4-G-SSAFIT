<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, ssafit.model.dto.Video" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영상 목록</title>
</head>
<body>
    <h1>영상 목록</h1>
    <p><a href="video_register.jsp">새로운 영상 등록</a></p>
    
    <% 
        List<Video> videoList = (List<Video>) request.getAttribute("videoList");
        if (videoList != null && !videoList.isEmpty()) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>제목</th>
                <th>부위</th>
                <th>채널명</th>
                <th>상세 보기</th>
            </tr>
        </thead>
        <tbody>
            <% for (Video video : videoList) { %>
            <tr>
                <td><%= video.getTitle() %></td>
                <td><%= video.getPart() %></td>
                <td><%= video.getChannelName() %></td>
                <td><a href="/video?videoId=<%= video.getId() %>">상세</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>등록된 영상이 없습니다.</p>
    <% } %>
    <p><a href="/">메인으로</a></p>
</body>
</html>