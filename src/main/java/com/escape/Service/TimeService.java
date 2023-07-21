package com.escape.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escape.entity.Time;
import com.escape.repository.TimeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeService {
 
	private final TimeRepository timeRepository;
	
	public List<Time> getTimeList(){
		return timeRepository.getTimeList();
	}
}
