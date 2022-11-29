package com.example.spring03.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member") // 다른 설정이 없는 경우 GET/POST/PUT/DELETE 모든 방식의 요청을 처리.
public class MemberController {

    @GetMapping("/signup") // GET 방식의 /member/signup 요청을 처리하는 메서드.
    public void signUp() {
        log.info("signUp() GET");
        // 컨트롤러 메서드의 리턴 타입이 void일 때 뷰의 이름은 요청 주소와 같음.
        // -> templates/member/signup.html
    }
    
}
