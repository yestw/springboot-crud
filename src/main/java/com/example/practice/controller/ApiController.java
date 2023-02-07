package com.example.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.LoginDTO;
import com.example.practice.dto.MemberDTO;
import com.example.practice.service.interfaces.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

	private  final MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity userSignup(@RequestBody MemberDTO formDTO) {
		return memberService.signup(formDTO);
	}


	@PostMapping("/signin")
	public ResponseEntity userSingin(@RequestBody LoginDTO loginDTO) {
		return memberService.signin(loginDTO);
	}
}
