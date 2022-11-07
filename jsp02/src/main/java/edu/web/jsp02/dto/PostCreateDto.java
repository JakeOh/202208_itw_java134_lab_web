package edu.web.jsp02.dto;

// VO(Value Object): 값(데이터) 저장하는 객체. DB의 테이블과 같은 구조로 설계. (예) Post
// DTO(Data Transfer Object): 계층들 사이에서 값(데이터)를 전달할 때 사용하는 객체.
//   controller(web) 계층과 service 계층 사이에서 
//   메서드를 호출할 때 argument의 타입 또는 메서드의 리턴 타입으로 사용되는 객체. 

public class PostCreateDto {
    
    private String title;
    private String content;
    private String author;

}
