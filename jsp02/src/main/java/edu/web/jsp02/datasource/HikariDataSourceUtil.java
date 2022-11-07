package edu.web.jsp02.datasource;

import com.zaxxer.hikari.HikariDataSource;

// HikariCP 라이브러리를 사용한 DataSource를 이용할 수 있는 유틸리티 클래스.
// -> Singleton 패턴
public class HikariDataSourceUtil {
    
    private static HikariDataSourceUtil instance = null;
    
    private HikariDataSourceUtil() {}
    
    public static HikariDataSourceUtil getInstance() {
        if (instance == null) {
            instance = new HikariDataSourceUtil();
        }
        
        return instance;
    }
    
    private HikariDataSource ds;
    
    public HikariDataSource getDataSource() {
        return ds;
    }

}
