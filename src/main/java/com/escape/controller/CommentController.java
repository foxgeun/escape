package com.escape.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.escape.Service.CommentService;
import com.escape.Service.ReserveService;
import com.escape.constant.ThemeSellStatus;
import com.escape.entity.Comment;
import com.escape.entity.Theme;
import com.escape.repository.CommentRepository;
import com.escape.repository.ThemeImgRepository;
import com.escape.repository.ThemeRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class CommentController {
		


	private final ThemeRepository themeRepository;
	private final CommentRepository commentRepository;
	
	@GetMapping(value = "/comment/{themename}")
	public String comment(Model model,@Valid Comment comment, @PathVariable("themename") String themename) {
		List<Theme> SearchthemeIdList = themeRepository.SearchthemeIdList(themename);

		
		model.addAttribute("searchthemeIdList", SearchthemeIdList);
		return "comment/comment";
	}
	
	@PostMapping(value = "/comment")
	public String comment2(Model model,@Valid Comment comment) {
		commentRepository.save(comment);
		

		return "redirect:/";
	}
	 
}
