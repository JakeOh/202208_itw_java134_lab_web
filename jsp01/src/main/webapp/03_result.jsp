<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
    <h1>Form submit 결과 페이지</h1>
    
    <% 
    request.setCharacterEncoding("UTF-8"); // 요청 파라미터의 한글 처리를 하기 위해서
    %>
    
    <h2>username : <%= request.getParameter("username") %></h2>
</body>
</html>