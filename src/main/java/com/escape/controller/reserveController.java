package com.escape.controller;



import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.escape.Service.ReserveService;
import com.escape.dto.ReserveDto;
import com.escape.entity.Reserve;
import com.escape.entity.Theme;
import com.escape.repository.ReserveRepository;
import com.escape.repository.ThemeRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@Controller
@RequiredArgsConstructor
public class reserveController {
	
	private final ReserveService reserveService;
	private final ThemeRepository themeRepository;
	
	
	
	@GetMapping(value = "/reserve/{time}/{themeName}/{date}")
	public String reserve(Model model, @PathVariable("time") String time, @PathVariable("themeName") String themeName, @PathVariable("date") String date) {
		List<Theme> ThemeList = themeRepository.getThemeList();
		List<Theme> SearchthemeIdList = themeRepository.SearchthemeIdList(themeName);
		
		
		
		
		model.addAttribute("themeList", ThemeList);
		model.addAttribute("searchthemeIdList", SearchthemeIdList);
		model.addAttribute("reserveDto" , new ReserveDto());
		return "reserve/reserve";
	}
	
	
	@PostMapping(value = "/reserve")
	public String reservein(@Valid ReserveDto reserveDto,
			Model model,Principal principal) {
			
		try {
						
			reserveService.saveReserve(reserveDto, principal.getName(), reserveDto.getTime());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/resupdate/{id}")
	public String reserve(Model model, @PathVariable("id") int id) {
		List<Reserve> updateList = reserveService.updateresList(id);
		Reserve updateReserve = reserveService.updateres(id);
		
		
		
		model.addAttribute("Reserve",updateReserve);
		model.addAttribute("resList" ,updateList);

		model.addAttribute("id" ,id);
		

		return "reserve/reserveupdate";
	}
	
	@PostMapping(value= "/resupdate/{id}")
	public String adupdate2( Model model, @PathVariable("id") int id,Reserve reserve) { 
		

		
		try {
			reserveService.updateReserve(reserve, id);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		
		}
		
		return "redirect:/";
	}
	
	@GetMapping(value= "/resdelete/{id}")
	public String addelete( Model model, @PathVariable("id") int id) { 
		

		
		try {
			reserveService.deleteReserve(id);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		
		}
		
		return "redirect:/";
	}
	
	
	
	
	
	
}
