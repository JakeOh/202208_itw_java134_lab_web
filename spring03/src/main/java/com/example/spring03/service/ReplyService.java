package com.example.spring03.service;

import org.springframework.stereotype.Service;

import com.example.spring03.domain.Post;
import com.example.spring03.domain.Reply;
import com.example.spring03.dto.ReplyRegisterDto;
import com.example.spring03.repository.PostRepository;
import com.example.spring03.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service // 스프링 컨텍스에 Service 컴포넌트로 등록. -> 의존성 주입이 가능해짐.
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;
    
    public Integer create(ReplyRegisterDto dto) {
        log.info("create(dto={})", dto);
        
        // 댓글이 달린 포스트를 검색
        Post post = postRepository.findById(dto.getPostId()).get();
        // DTO를 Reply 엔터티로 변환
        Reply reply = Reply.builder()
                .post(post).replyText(dto.getReplyText()).writer(dto.getWriter())
                .build();
        // 테이블에 저장
        reply = replyRepository.save(reply);
        
        return reply.getId(); // 테이블에 저장된 댓글 번호(아이디)를 리턴.
    }
    
}
