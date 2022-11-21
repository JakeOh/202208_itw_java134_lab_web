package com.example.spring03.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity(name = "POSTS")
// 엔터티 클래스와 데이터베이스 테이블의 이름이 다르면 반드시 name 속성을 지정.
@SequenceGenerator(name = "POSTS_SEQ_GEN", sequenceName = "POSTS_SEQ", initialValue = 1, allocationSize = 1)
public class Post {
    @Id // Primary Key(고유키)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTS_SEQ_GEN")
    private Integer id;
    
    @Column(nullable = false) // Not Null 제약조건
    private String title;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private String author;

}
