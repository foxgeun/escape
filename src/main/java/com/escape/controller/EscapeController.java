package com.escape.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.escape.entity.ThemeImg;
import com.escape.repository.ThemeImgRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EscapeController {
	
	
	private final ThemeImgRepository themeImgRepository;
	

		@GetMapping(value = "/")
		public String index(Model model) {
			
			List<ThemeImg> imgList = themeImgRepository.getImgList();
			LocalDate now = LocalDate.now();
			

			model.addAttribute("now" ,now);
			model.addAttribute("imgList", imgList);
			
			return "/index";
		}
		
		
		
		
		
}
