package com.example.practice.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.example.practice.dto.LoginDTO;
import com.example.practice.dto.MemberDTO;

public interface MemberService {
	ResponseEntity signup(MemberDTO formDTO);

	ResponseEntity signin(LoginDTO loginDTO);
}
