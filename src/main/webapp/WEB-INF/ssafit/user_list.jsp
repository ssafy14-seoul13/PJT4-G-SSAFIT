<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, ssafit.model.dto.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 목록</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
    <h1>회원 목록</h1>
    <p><a href="user?act=writeform">새로운 회원 가입</a></p>
    
    <% 
        List<User> userList = (List<User>) request.getAttribute("list");
        if (userList != null && !userList.isEmpty()) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>이메일</th>
                <th>상세 보기</th>
            </tr>
        </thead>
        <tbody>
            <% for (User user : userList) { %>
            <tr>
                <td><%= user.getUserId() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><a href="user?act=detail&userId=<%= user.getUserId() %>">상세</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>등록된 회원이 없습니다.</p>
    <% } %>
    <p><a href="index.jsp">메인으로</a></p>
</body>
</html>