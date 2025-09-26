<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.ssafy.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 목록</title>
</head>
<body>
    <h1>회원 목록</h1>
    <p><a href="user_register.jsp">새로운 회원 가입</a></p>
    
    <% 
        List<UserDTO> userList = (List<UserDTO>) request.getAttribute("userList");
        if (userList != null && !userList.isEmpty()) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>아이디</th>
                <th>이름</th>
                <th>이메일</th>
                <th>상세 보기</th>
            </tr>
        </thead>
        <tbody>
            <% for (UserDTO user : userList) { %>
            <tr>
                <td><%= user.getUserId() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><a href="/user?userId=<%= user.getUserId() %>">상세</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>등록된 회원이 없습니다.</p>
    <% } %>
    <p><a href="/">메인으로</a></p>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.ssafy.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 목록</title>
</head>
<body>
    <h1>회원 목록</h1>
    <p><a href="user_register.jsp">새로운 회원 가입</a></p>
    
    <% 
        List<UserDTO> userList = (List<UserDTO>) request.getAttribute("userList");
        if (userList != null && !userList.isEmpty()) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>아이디</th>
                <th>이름</th>
                <th>이메일</th>
                <th>상세 보기</th>
            </tr>
        </thead>
        <tbody>
            <% for (UserDTO user : userList) { %>
            <tr>
                <td><%= user.getUserId() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><a href="/user?userId=<%= user.getUserId() %>">상세</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>등록된 회원이 없습니다.</p>
    <% } %>
    <p><a href="/">메인으로</a></p>
</body>
</html>