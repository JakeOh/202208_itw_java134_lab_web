package com.example.spring01.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

// POJO(Plain Old Java Object): 평범한 자바 객체.
// 특정 클래스를 상속해야만 하거나, 상속 후엔 메서드들을 반드시 override해야만 하는 클래스가 아님.

@Slf4j
@Controller // 컴포넌트 애너테이션 중 하나. 웹 요청을 처리하는 Controller 계층의 컴포넌트.
//-> @Controller 애너테이션 + sevelt-context.xml 설정 <context:component-scan>
//-> 스프링에서 객체를 생성해서 메모리에 로딩하고 관리. -> 객체의 메서드들을 필요할 때 호출.
public class ExampleController {
    
    @GetMapping("/")
    public String home() {
        log.info("home()");
        
        return "index"; // (1)
    }
    
    @GetMapping("/ex1")
    public void example1() {
        log.info("example1()"); // (2)
    }

    // View Resolver(뷰를 찾는 객체)가 뷰(JSP)를 찾는 방법:
    // (1) 컨트롤러 메서드가 문자열을 리턴하면, 그 문자열이 파일의 이름(/WEB-INF/views/문자열.jsp).
    // (2) 컨트롤러 메서가 리턴하지 않는 경우(void), 요청 주소 이름이 뷰의 이름.
    
    @GetMapping("/ex2")
    public void ex2(String username, int age, Model model) {
        log.info("ex2(username={}, age={})", username, age);
        
        model.addAttribute("username", username);
        model.addAttribute("age", age);
    }
    
}
