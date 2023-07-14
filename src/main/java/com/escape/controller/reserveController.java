package com.escape.controller;



import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import com.escape.Service.ReserveService;
import com.escape.dto.ReserveDto;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@Controller
@RequiredArgsConstructor
public class reserveController {
	
	private final ReserveService reserveService;
	
	@GetMapping(value = "/reserve")
	public String reserve(Model model) {
		model.addAttribute("reserveDto" , new ReserveDto());
		return "reserve/reserve";
	}
	
	
	@PostMapping(value = "/reserve")
	public String reservein(@Valid ReserveDto reserveDto, 
			Model model,Principal principal) {
		
		try {
			System.out.println("실행");			
			reserveService.saveReserve(reserveDto, principal.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	
}
