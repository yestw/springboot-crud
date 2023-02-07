package com.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
