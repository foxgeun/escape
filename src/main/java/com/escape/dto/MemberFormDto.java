package com.escape.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.escape.entity.Member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberFormDto {
		
	private String id;
	
	@NotBlank(message = "이름은 필수입력 값입니다")
	private String name;
	
	@Email(message = "이메일은 형식으로 입력해주세요")
	@NotEmpty(message = "이메일은 필수입력 값입니다")
	private String email;
	
	@NotEmpty(message = "비밀번호은 필수입력 값입니다")
	@Length(min=8, max=16, message="비밀번호는 8자~16자 사이로 입력해주세요")
	private String password;
	

	
	private static ModelMapper modelMapper = new ModelMapper();
	
	//dto -> entity로 바꿈
	public Member createmember() {
		return modelMapper.map(this, Member.class);
	}
	
	//entity -> dto로 바꿈
	public static MemberFormDto of(Member member) {
		
		return modelMapper.map(member, MemberFormDto.class);
	}
	
	
	
}
