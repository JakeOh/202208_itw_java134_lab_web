package com.example.spring03.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring03.dto.PostCreateDto;
import com.example.spring03.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {
    
    private final PostService postService;
    
    @GetMapping("/create") // GET 방식의 /post/create 요청을 처리하는 메서드.
    public void create() {
        log.info("create()");
        // 컨트롤러 메서드의 리턴 타입이 void인 경우 뷰의 이름은 요청 주소와 같음.
        // src/main/resources/templates/post/create.html
    }
    
    @PostMapping("/create") // Post 방식의 /post/create 요청을 처리하는 메서드.
    public String create(PostCreateDto dto) {
        log.info("create(dto={})", dto);
        
        // TODO: 새 포스트 작성
        
        // PRG(Post-Redirect-Get) 패턴.
        return "redirect:/";
    }
    

}