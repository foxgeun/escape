package com.escape.dto;

import org.modelmapper.ModelMapper;

import com.escape.constant.ThemeSellStatus;
import com.escape.entity.Theme;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ThemeFormDto {

	
	@Id
	@Column(name="theme_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;	//이름
	
	private int price;
	
	private String detail;
	
	@Enumerated(EnumType.STRING)
	private ThemeSellStatus themeSellStatus;
	
	private int level;
	
	private int horror;
	
	private String people;
	
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Theme createTheme() {
		return modelMapper.map(this, Theme.class);
	}
	
	public static ThemeFormDto of(Theme theme) {
		return modelMapper.map(theme, ThemeFormDto.class);
	}
	
	
}
