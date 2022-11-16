package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.domain.Post;
import com.example.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post")
//-> 클래스에 @RequestMapping 애너테이션을 사용하면, 
// 그 클래스의 모든 메서드들의 매핑 주소는 @RequestMapping에서 설정된 URL로 시작함.
@Controller // 스프링 컨테이너가 Bean으로 생성, 관리
public class PostController {

    private final PostService postService; // 생성자에 의한 의존성 주입
    
    @GetMapping("/list")
    public String list(Model model) {
        log.info("list()");
        
        // Service 계층의 메서드를 사용해서 포스트 전체 목록을 검색함.
        List<Post> list = postService.read();
        
        // 포스트 목록을 뷰에 전달하기 위해서 model을 이용.
        model.addAttribute("list", list);
        
        return "/post/list"; // 뷰 이름 - /WEB-INF/views/post/list.jsp
    }
    
    // 새 글 작성
    @GetMapping("/create")
    public String create() {
        log.info("create()");
        
        return "/post/create";
    }
    
    //상세보기/수정페이지/수정/삭제 컨트롤러 메서드
    
}
