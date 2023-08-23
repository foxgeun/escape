package com.escape.entity;

import com.escape.dto.ReserveDto;

import jakarta.persistence.*;
import lombok.*;

@Entity //엔티티 클래스로 정의
@Table(name="reserve") //테이블 이름저장
@Getter
@Setter
@ToString
public class Reserve extends BaseEntity{
	
	@Id
	@Column(name="reserve_id") //테이블로 생성될때 컬럼이름을 지정해준다
	@GeneratedValue(strategy = GenerationType.AUTO) //기본키를 자동으로 생성해주는 전략 사용
	private long id;
	

	private String themeName; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	private String name;
	
	private String time;
	
	private String date;
	
	private int price;
	
	private int cnt;

	private int cal;
	
	
	public void updateReserve(Reserve reserve) {
		
		this.themeName = reserve.themeName;
		this.time = reserve.time;
		this.date = reserve.date;
		this.name = reserve.name;
		
		
	}

	public static Reserve createReserve(ReserveDto reserveDto) {
		
		Reserve reserve = new Reserve();
		reserve.setName(reserveDto.getName());
		reserve.setCnt(reserveDto.getCnt());
		
		
		return reserve;
	}
	
		
}


