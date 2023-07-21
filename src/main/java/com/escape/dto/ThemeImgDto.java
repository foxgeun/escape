package com.escape.dto;

import org.modelmapper.ModelMapper;

import com.escape.entity.ThemeImg;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThemeImgDto {
	
	private Long id;
	
	private String imgName;
	
	private String oriImgName;
	
	private String imgUrl; 
	
	private String repimgYn; 
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static ThemeImgDto of(ThemeImg themeImg) {
		return modelMapper.map(themeImg, ThemeImgDto.class);
	}
}
