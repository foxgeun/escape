package com.escape.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escape.dto.ReserveDto;
import com.escape.entity.Member;
import com.escape.repository.MemberRepository;
import com.escape.repository.ReserveRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ThemeService {

	private final ReserveRepository reserveRepository;
	private final MemberRepository memberRepository;
	
	public void findres(ReserveDto reserveDto, String email) throws Exception{
		Member member = memberRepository.findByEmail(email);
		
	}
	
	
}
