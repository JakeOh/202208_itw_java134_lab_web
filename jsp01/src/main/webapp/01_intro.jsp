<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <style>
        /* CSS 주석 */
    </style>
</head>
<body>
    <!-- HTML/XML 주석 -->
    <script>
        /* JavaScript 블록 주석 */
        // JavaScript 인라인 주석
    </script>
    
    <%-- JSP 주석 --%>
    <%-- Servlet/JSP 동작 방식
    Servlet: Server + Applet 합성어. (웹 서버에서 실행되는, 요청을 처리하는 작은 프로그램).
      - 웹 서버가 클라이언트로부터 요청을 받았을 때 동적으로 HTML 문서를 생성하기 위한 기술.
      - Java class로 작성.
      - Servlet의 생성과, Servlet 객체의 메서드 호출은 WAS가 담당.
        * 최초 요청 -> Servlet 객체 생성 -> doGet/doPost 메서드를 호출 -> 응답
        * 요청 -> 생성된 Servlet 객체의 doGet/doPost 메서드를 호출 -> 응답
      
    JSP: Java Server Page
    Servlet은 순수한 Java 코드이기 때문에 HTML을 작성하는 것이 힘듦.
    HTML 형식의 문서에서 Java 코드들이 실행될 수 있도록 만든 Server-side 기술.
    --%>
    
    <% /* Java 블록 주석 */
    System.out.println("01_intro.jsp"); // Java 인라인 주석 
    %>
    
    <h1>첫번째 JSP(Java Server Page)</h1>
    
    <% LocalDateTime now = LocalDateTime.now(); %>
    <h2>서버 시간: <%= now.toString() %></h2>
    
    
</body>
</html>
