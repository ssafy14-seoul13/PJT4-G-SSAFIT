<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 상세 정보</title>
</head>
<body>
    <h1>회원 상세 정보</h1>
    <%
        UserDTO user = (UserDTO) request.getAttribute("user");
        if (user != null) {
    %>
    <form action="/user" method="post">
        <input type="hidden" name="userId" value="<%= user.getUserId() %>">
        
        <label>아이디:</label>
        <%= user.getUserId() %><br><br>
        
        <label for="name">이름:</label><br>
        <input type="text" id="name" name="name" value="<%= user.getName() %>" required><br><br>
        
        <label for="email">이메일:</label><br>
        <input type="email" id="email" name="email" value="<%= user.getEmail() %>" required><br><br>
        
        <label for="password">비밀번호:</label><br>
        <input type="password" id="password" name="password" placeholder="비밀번호를 변경하려면 입력하세요"><br><br>
        
        <button type="submit" name="_method" value="put">수정하기</button>
    </form>
    
    <form action="/user" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="hidden" name="userId" value="<%= user.getUserId() %>">
        <button type="submit">삭제하기</button>
    </form>
    <% } else { %>
    <p>회원 정보를 찾을 수 없습니다.</p>
    <% } %>
    <p><a href="/user/list">회원 목록으로</a></p>
</body>
</html>