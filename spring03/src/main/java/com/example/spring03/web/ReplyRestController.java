package com.example.spring03.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring03.dto.ReplyRegisterDto;
import com.example.spring03.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController // REST 서비스에서 사용되는 컨트롤러 객체
//-> @Controller 클래스의 메서드 리턴값(String) => 뷰(html) 이름.
//-> @RestController 클래스의 메서드 리턴값 => 클라이언트로 전송되는 값(response.data)!
@RequestMapping("/api/reply")
public class ReplyRestController {
    
    private final ReplyService replyService;
    
    @PostMapping // 댓글 등록 REST 서비스
    public ResponseEntity<Integer> registerReply(@RequestBody ReplyRegisterDto dto) {
        // Ajax 요청에서 서버로 보내는 데이터 HTTP 패킷의 body에 포함됨.
        // @RequestBody: HTTP 패킷 body에 포함된 데이터(파라미터)를 분석할 때 사용.
        log.info("registerReply(dto={})", dto);
        
        // 댓글을 데이터베이스 테이블에 등록.
        Integer replyId = replyService.create(dto);
        
        // 작성된 댓글의 아이디를 응답 데이터(response data)로 만들어서, Ajax 요청에 대한 성공 응답을 전송.
        return ResponseEntity.ok(replyId);
    }

}
