package com.escape.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity //엔티티 클래스로 정의
@Table(name="time") //테이블 이름저장
@Getter
@Setter
@ToString
public class Time {
	
	
	@Id
	@Column(name="time_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	String time;
	
	String date;
	
	String theme;
	
	public void updateTime(String date) {
		
		if(this.date == null) {
			this.date = date;
		}else {
			this.date += date + ", ";
			
		}	
	}
	
}
