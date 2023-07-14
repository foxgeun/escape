package com.escape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escape.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	//select * from member where eamil= ?
	Member findByEmail(String email);
	
	
}
