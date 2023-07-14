package com.escape.dto;


import org.modelmapper.ModelMapper;

import com.escape.entity.Member;
import com.escape.entity.Reserve;
import com.escape.entity.Theme;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReserveDto {
	
	private long id;
	
	private String Time;

	@NotNull(message = "상품 아이디는 필수 입력 값입니다.")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id")
	private Theme theme; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
		
	private int cnt;
	
	private int cal;
	
	private int price;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Reserve createReserve(Member member) {
		this.member = member;
		return modelMapper.map(this, Reserve.class);
	}
	
	public static ReserveDto of(Reserve reserve) {
		return modelMapper.map(reserve, ReserveDto.class);
	}
	
}
