package com.escape.Service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escape.dto.MemberFormDto;
import com.escape.entity.Member;
import com.escape.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional //쿼리문 수행시 에러가 발생하면 변경된 데이터를 이전상태로 콜백시켜준다 
@RequiredArgsConstructor  // @Autowired를 사용하지 않고 필드의 의존성을 주입시켜준다
public class MemberService implements UserDetailsService{

	private final MemberRepository memberRepository;
	

	//회원가입 데이터를 DB에 저장한다
	public Member saveMember(Member member) {
		
		validateDuplicateMember(member);
		Member savedMember = memberRepository.save(member);
		return savedMember;
	}
	
	
	//이메일 중복체크
	private void validateDuplicateMember(Member member) {

		Member findMember = memberRepository.findByEmail(member.getEmail());
		
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//사용자가 입력한 email로 DB에 있는지 쿼리문을 사용한다.
		Member member = memberRepository.findByEmail(email);
		
		if(member == null) {
			throw new UsernameNotFoundException(email);
		}
		
		//사용자가 있다면 
		return User.builder()
				.username(member.getEmail())
				.password(member.getPassword())
				.roles(member.getRole().toString())
				.build();
	}
	
	//상품 가져오기
	@Transactional(readOnly = true) //트랜잭션 읽기 전용(변경감지 수행하지 않음) -> 성능향상
	public MemberFormDto getMember(String email) {
		Member member = memberRepository.findByEmail(email);
		


		MemberFormDto memberFormDto = MemberFormDto.of(member);
		
		return memberFormDto; 
	}
	
	
	

	
	
	
	
	
	
	
}
