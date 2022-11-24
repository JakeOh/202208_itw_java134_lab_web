package com.example.spring03.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // REST 서비스에서 사용되는 컨트롤러 객체
//-> @Controller 클래스의 메서드 리턴값(String) => 뷰(html) 이름.
//-> @RestController 클래스의 메서드 리턴값 => 클라이언트로 전송되는 값(response.data)!
@RequestMapping("/api/reply")
public class ReplyRestController {
    
    @PostMapping // 댓글 등록 REST 서비스
    public String registerReply() {
        log.info("registerReply()");
        // 댓글 데이터베이스 테이블에 등록.
        return "REST 성공";
    }

}
