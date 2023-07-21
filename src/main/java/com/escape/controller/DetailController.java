package com.escape.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.escape.entity.Theme;
import com.escape.entity.ThemeImg;
import com.escape.repository.ThemeImgRepository;
import com.escape.repository.ThemeRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DetailController {
	
	private final ThemeRepository themeRepository;
	private final ThemeImgRepository themeImgRepository;
	
	@GetMapping(value = "/details")
	public String ddd(){
		return "detail/details";
	}
	
	
	
	@GetMapping(value = "/details/{id}")
	public String details(Model model, @PathVariable("id") int id) {
		
		List<Theme> SearchthemeIdList = themeRepository.SearchthemeIdList2(id);
		List<ThemeImg> SearchthemeImgIdList = themeImgRepository.SearchthemeIdList(id);
		
		
		
		model.addAttribute("searchthemeIdList", SearchthemeIdList);
		model.addAttribute("searchthemeImgIdList",SearchthemeImgIdList);
		return "detail/details";
	}
}
