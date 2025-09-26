<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
</head>
<body>
    <h1>회원 가입</h1>
    <form action="user" method="POST">
    	<input type="hidden" name="act" value="write">
        <label for="userId">아이디:</label><br>
        <input type="text" id="userId" name="userId" required><br><br>
        
        <label for="password">비밀번호:</label><br>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="name">이름:</label><br>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="email">이메일:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        
        <button type="submit">회원 가입</button>
    </form>
    <p><a href="/">메인으로</a></p>
</body>
</html>