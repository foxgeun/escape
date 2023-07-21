package com.escape.entity;


import java.util.Date;

import com.escape.constant.ThemeSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity //엔티티 클래스로 정의
@Table(name="theme") //테이블 이름저장
@Getter
@Setter
@ToString
public class Theme {
	
	@Id
	@Column(name="theme_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;	//이름
	
	private int price;
	
	@Column(nullable = false, columnDefinition = "longtext")
	private String detail;
	
	@Enumerated(EnumType.STRING)
	private ThemeSellStatus themeSellStatus;
	

	
	private int level;
	
	private int horror;
	
	private String people;
	
	private String imgUrl;
	
	
	
	
	
	
	
}
