<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    
    <h2>로그인</h2>
    
    <% String error = (String) request.getAttribute("error");
       if (error != null) { %>
        <div style="color: red;"><%= error %></div>
    <% } %>
    
    <form action="user" method="POST">
        <input type="hidden" name="act" value="login">
        
        <label for="userId">아이디:</label><br>
        <input type="text" id="userId" name="userId" required><br><br>
        
        <label for="password">비밀번호:</label><br>
        <input type="password" id="password" name="password" required><br><br>
        
        <button type="submit">로그인</button>
    </form>
    
    <p><a href="index.jsp">메인으로</a></p>
</body>
</html>