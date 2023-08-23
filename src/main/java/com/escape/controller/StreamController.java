package com.escape.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.escape.Service.ReserveService;
import com.escape.Service.TimeService;
import com.escape.dto.ReserveDto;
import com.escape.entity.Reserve;
import com.escape.entity.Theme;
import com.escape.entity.Time;
import com.escape.repository.ThemeRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StreamController {
	List<Boolean> wpqkf;
	private final ReserveService reserveService;
	private final ThemeRepository themeRepository;
	private final TimeService timeService;

	@GetMapping(value = "/streams")
	public String main(ReserveDto reserveDto, Optional<Integer> page, Model model,Principal principal)throws Exception  {
		
		List<Theme> ThemeList = themeRepository.getThemeList();
		List<Reserve> resList = reserveService.getresList();	

	
		model.addAttribute("themeList", ThemeList);
		model.addAttribute("resList", resList);
		return "stream/streams";
		
		
	}
	
	@GetMapping(value = "/streams/{date}")
	public String sub(ReserveDto reserveDto, Optional<Integer> page, Model model, @PathVariable("date") String date)throws Exception  {
		

		
		List<Theme> ThemeList = themeRepository.getThemeList();
		List<Reserve> resList = reserveService.getresList();
		List<Reserve> btnList = reserveService.getbtnList();
		List<Time> timeList = timeService.getTimeList();

		List<Reserve> AA = new ArrayList<>();
		
		
		for(Time time : timeList) {
			AA.add(reserveService.getwpqkfList(date, time.getTime()));
			
		}

		LocalDate now = LocalDate.now();

		
		

		model.addAttribute("new" ,now);
		model.addAttribute("AA", AA);
		model.addAttribute("themeList", ThemeList);
		model.addAttribute("resList", resList);
		model.addAttribute("btnList",btnList);
		model.addAttribute("time", timeList);
		model.addAttribute("date", date);		
		
		
		
		
		return "stream/streams";
		
		
	}
	
	
	
}
