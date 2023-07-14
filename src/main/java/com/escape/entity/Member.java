package com.escape.entity;



import org.springframework.security.crypto.password.PasswordEncoder;

import com.escape.constant.Role;
import com.escape.dto.MemberFormDto;

import jakarta.persistence.*;
import lombok.*;

@Entity //엔티티 클래스로 정의
@Table(name="member") //테이블 이름저장
@Getter
@Setter
@ToString
public class Member {
	
	@Id
	@Column(name="member_id") //테이블로 생성될때 컬럼이름을 지정해준다
	@GeneratedValue(strategy = GenerationType.AUTO) //기본키를 자동으로 생성해주는 전략 사용
	private long id;
	
	@Column(unique = true) //중복된 값이 들어올수없다
	private String email;
	
	private String password;
	
	
	private String name;
	
	@Enumerated(EnumType.STRING) //enum의 이름을 DB에 저장
	private Role role; //역할
	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		String password = passwordEncoder.encode(memberFormDto.getPassword());
		
		
		//memberFormDto -> Member 엔티티 객체로 변환
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		member.setPassword(password);
		member.setRole(Role.ADMIN);
		
		
		return member;
	}

	private String que;
	
	private String ans;
	
}
