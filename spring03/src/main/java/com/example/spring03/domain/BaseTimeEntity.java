package com.example.spring03.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

// 대부분의 테이블들은 데이터 생성/수정 시간을 컬럼으로 갖는 경우가 많음.
// 여러 테이블에서 공통으로 사용되는 (생성/수정) 시간 컬럼들만 갖는 상위 클래스를 정의하고,
// 엔터티 클래스들에서 상위 클래스를 상속받는 구조로 만들기 위해서 정의.
// 엔터티(데이터)들이 생성/수정 이벤트가 발생됐을 때 자동으로 시간을 기록하기 위해서.
public class BaseTimeEntity {
    
    @CreatedDate // 생성 날짜(시간)
    private LocalDateTime createdTime;
    
    @LastModifiedDate // 최종 수정 날짜(시간)
    private LocalDateTime modifiedTime;

}
