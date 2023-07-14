package com.escape.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.escape.Service.ReserveService;
import com.escape.dto.ReserveDto;
import com.escape.entity.Reserve;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StreamController {
	
	private final ReserveService reserveService;

	@GetMapping(value = "/streams")
	public String main(ReserveDto reserveDto, Optional<Integer> page, Model model,Principal principal)throws Exception  {
		
		List<Reserve> resList = reserveService.getresList();	
	
		model.addAttribute("resList", resList);
		return "stream/streams";
		
		
	}
}
