package com.escape.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.escape.entity.ThemeImg;
import com.escape.repository.ThemeImgRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BrowseController {
	
	private final ThemeImgRepository themeImgRepository;
	
	@GetMapping(value = "/browse")
	public String browse(Model model) {
		
		
		List<ThemeImg> imgList = themeImgRepository.getImgList();

		model.addAttribute("imgList", imgList);
		
		
		
		return "browse/browse";
	}
	
}
