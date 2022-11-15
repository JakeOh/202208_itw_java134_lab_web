package com.example.spring02.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/applicationContext.xml"
})
public class TestMapper {
    
    @Autowired
    private PostMapper postMapper;
    
    @Test
    public void testPostMapper() {
        Assertions.assertNotNull(postMapper);
        log.info("postMapper = {}", postMapper);
    }

}
