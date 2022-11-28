package com.example.spring03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring03.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
