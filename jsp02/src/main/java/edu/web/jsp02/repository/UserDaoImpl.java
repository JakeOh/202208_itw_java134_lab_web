package edu.web.jsp02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.User;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoImpl implements UserDao {
    
    private HikariDataSource ds;

    private static UserDaoImpl instance = null;
    
    private UserDaoImpl() {
        ds = HikariDataSourceUtil.getInstance().getDataSource();
    }
    
    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        
        return instance;
    }

    private static final String SQL_INSERT_USER = 
            "insert into USERS (USERNAME, PASSWORD, EMAIL) values (?, ?, ?)";
    
    @Override
    public int insert(User entity) {
        log.info("insert(entity = {})", entity);
        
        int result = 0; // DB 테이블에 insert한 결과를 저장할 변수
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT_USER);
            log.info(SQL_INSERT_USER);
            
            // prepared statement의 바인딩 파라미터(binding parameter) 값들을 세팅.
            stmt.setString(1, entity.getUsername());
            stmt.setString(2, entity.getPassword());
            stmt.setString(3, entity.getEmail());
            
            // SQL 실행
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }

}
