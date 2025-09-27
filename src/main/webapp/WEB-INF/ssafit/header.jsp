<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ssafit.model.dto.User" %>

<div style="background-color: #f8f9fa; padding: 10px; border-bottom: 1px solid #dee2e6;">
    <%
        String userId = (String)session.getAttribute("userId");
        if (userId != null) {
    %>
        <div style="float: right;">
            <span><strong><%= userId %></strong>회원님 안녕하세요!</span>
            <a href="user?act=logout" style="margin-left: 10px;">[로그아웃]</a>
        </div>
    <%
        } else {
    %>
        <div style="float: right;">
            <a href="user?act=loginform">[로그인]</a>
        </div>
    <%
        }
    %>
    <div style="clear: both;"></div>
</div>