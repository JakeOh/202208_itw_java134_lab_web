<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
    <h1>포스트 등록 결과 페이지</h1>
    
    <form>
        <div>
            <label>번호</label>
            <input type="number" name="id" value="${ post.id }" readonly />
        </div>
        <div>
            <label>제목</label>
            <input type="text" name="title" value="${ post.title }" readonly />
        </div>
        <div>
            <textarea rows="5" cols="80" name="content" readonly>${ post.content }
            </textarea>
        </div>
        <div>
            <input type="datetime-local" name="createdTime" value="${ post.createTime }" readonly />
        </div>
    </form>
</body>
</html>
