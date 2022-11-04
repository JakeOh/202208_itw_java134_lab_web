package edu.web.jsp02.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import oracle.jdbc.OracleDriver;
import oracle.security.o3logon.a;


// JUnit Test(자바 단위 테스트)
// JDBC(Java Database Connectivity) - ojdbc8 라이브러리 연결 테스트
public class OjdbcTest {
    
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";
    private static final String SQL_SELECT = "select * from POSTS order by ID desc";
    
    // JUnit test: JUnit 모듈에서 테스트를 하기 위해서 호출하는 메서드.
    //   (1) 가시성: public. (2) 리턴 타입: void. (3) 파라미터를 갖지 않음.
    @Test
    public void testOjdbc() throws SQLException {
        // 1. 드라이버(라이브러리) 관리자에 OJDBC 라이브러리를 등록.
        DriverManager.registerDriver(new OracleDriver());
        
        // 2. 등록된 JDBC 라이브러리를 사용해서 Oracle 데이터베이스와 연결
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Assertions.assertNotNull(conn);
        //-> conn이 null이 아니면 단위 테스트 성공, null이면 실패.
        
        // 3. Statement 준비
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
        
        // 4. SQL 실행
        ResultSet rs = stmt.executeQuery();
        
        // 5. 결과 처리
        while (rs.next()) { // select 결과 행(row)이 있으면,
            Integer id = rs.getInt("ID"); // 포스트 글 번호
            String title = rs.getString("TITLE"); // 포스트 글 제목
            String content = rs.getString("CONTENT"); // 포스트 글 내용
            String author = rs.getString("AUTHOR"); // 포스트 작성자 아이디
            // DB 테이블의 Timestamp 타입 값을 자바의 LocalDateTime 타입으로 변환.
            LocalDateTime createdTime = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
            LocalDateTime modifiedTime = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
            
            String row = String.format("%d | %s | %s | %s | %s | %s", 
                    id, title, content, author, createdTime, modifiedTime);
            System.out.println(row);
        }
        
        // 사용했던 리소스 해제 - 생성된 순서의 반대로 close() 호출.
        rs.close();
        stmt.close();
        conn.close();
    }

}
