package com.escape.dto;



import org.modelmapper.ModelMapper;




import com.escape.entity.Time;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TimeDto {
	
	

	private long id;
	
	String time;
	
	String date;
	
	String theme;
	
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Time createTime() {
		return modelMapper.map(this, Time.class);
	}
	
	public static TimeDto of(Time time) {
		return modelMapper.map(time, TimeDto.class);
	}
	
	
}
