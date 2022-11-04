package edu.web.jsp02.hikaricp;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// DBCP(Database Connection Pool) - Data Source
// HikariCP 라이브러리 테스트
public class DbcpTest {
    
    @Test
    public void testHikariCP() throws SQLException {
        // HikariCP 설정을 위한 객체 생성.
        HikariConfig config = new HikariConfig();
        
        // Connection Pool(Data Source) 생성을 위한 환경 설정 세팅.
        config.setDriverClassName("oracle.jdbc.OracleDriver"); // 연결을 맺기 위한 DB 드라이버.
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB 서버 URL
        config.setUsername("scott"); // 접속 계정
        config.setPassword("tiger"); // 접속 비밀번호
        config.addDataSourceProperty("cachePrepStmt", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        
        // 위의 설정들을 갖는 Connection Pool(Data Source) 객체 생성.
        HikariDataSource ds = new HikariDataSource(config);
        Assertions.assertNotNull(ds); // DataSource는 null이 되면 안됨.
        System.out.println(ds);
        
        // Connection Pool(Data Source)에서 Connection 객체를 빌려옴.
        Connection conn = ds.getConnection();
        Assertions.assertNotNull(conn); // Connection은 null이 되면 안됨.
        System.out.println(conn);
        
        // 사용했던 Connection을 Connection Pool(Data Source)에 반환.
        conn.close();
    }

}
