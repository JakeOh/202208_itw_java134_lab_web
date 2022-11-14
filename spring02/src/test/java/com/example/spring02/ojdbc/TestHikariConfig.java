package com.example.spring02.ojdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/applicationContext.xml"
})
public class TestHikariConfig {
    
    // 의존성 주입(dependency injection)
    // 제어의 역전(IoC: Inversion of Control)
    // 전통적인 자바 개발에서는 객체를 사용하는 곳에서 생성자를 호출하고, 메서드를 이용.
    // 스프링에서는 스프링 컨테이너가 필요한 객체들을 미리 메모리에 생성해 두고,
    // 필요한 곳에서 변수 선언과 애너테이션을 사용하면, 
    // 스프링 컨테이너가 필요한 곳에 객체를 주입하는 개발 방식.
    
//    @Autowired // 스프링 컨테이너에서 (생성하고) 관리하는 bean을 변수에 자동 할당.
//    private HikariConfig config;
    
    @Autowired
    private HikariDataSource ds;
    
    @Test
    public void testHikariConfig() throws SQLException {
//        Assertions.assertNotNull(config);
//        log.info("config = {}", config);
        
        Assertions.assertNotNull(ds);
        log.info("ds = {}", ds);
        
        Connection conn = ds.getConnection(); // Data Source에서 DB 연결을 빌려옴.
        Assertions.assertNotNull(conn);
        log.info("conn = {}", conn);
        
        conn.close(); // 사용했던 DB 연결을 Data Source에 반환.
    }

}
