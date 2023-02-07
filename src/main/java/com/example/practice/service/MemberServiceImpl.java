package com.example.practice.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.practice.domain.Member;
import com.example.practice.dto.LoginDTO;
import com.example.practice.dto.MemberDTO;
import com.example.practice.repository.MemberRepository;
import com.example.practice.service.interfaces.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@Override
	public ResponseEntity signup(MemberDTO formDTO) {

		Optional<Member> member = memberRepository.findById(formDTO.getId());

		if (member.isEmpty()) {
			Member newMember = Member.builder()
				.id(formDTO.getId())
				.pw(formDTO.getPw())
				.name(formDTO.getName())
				.build();

			memberRepository.save(newMember);

			return new ResponseEntity("success", HttpStatus.OK);
		} else {
			return new ResponseEntity("fail", HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity signin(LoginDTO loginDTO) {

		Optional<Member> member = memberRepository.findById(loginDTO.getId());
		Member memberEntity = member.orElse(null);

		if(member.isEmpty()) {
			return new ResponseEntity("아이디가 존재하지 않습니다.", HttpStatus.OK);
		}

		if(memberEntity.getPw().equals(loginDTO.getPw())) {
			return new ResponseEntity("success", HttpStatus.OK);
		} else {
			return new ResponseEntity("비밀번호가 일치하지 않습니다.", HttpStatus.OK);
		}

	}
}
