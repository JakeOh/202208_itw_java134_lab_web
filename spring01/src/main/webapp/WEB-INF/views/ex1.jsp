<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring 1</title>
</head>
<body>
    
    <h1>Example 1</h1>
    
    <c:url var="ex2" value="/ex2"></c:url>
    <form action="${ ex2 }" method="get">
        <input type="text" name="username" placeholder="사용자 이름" />
        <input type="number" name="age" placeholder="나이" />
        <input type="submit" value="제출" />
    </form>
    
</body>

</html>