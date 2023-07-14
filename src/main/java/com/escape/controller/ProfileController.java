package com.escape.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;



import com.escape.Service.MemberService;
import com.escape.Service.ReserveService;
import com.escape.dto.MemberFormDto;

import com.escape.entity.Reserve;



@Controller
public class ProfileController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ReserveService reserveService;
	
	@GetMapping(value ="/profile")
	public String profile(Model model, Principal principal, Optional<Integer> page) throws Exception {
		

		List<Reserve> resList = reserveService.findres(principal.getName());	
		
		MemberFormDto memberFormDto = memberService.getMember(principal.getName());
		
		model.addAttribute("resList", resList);
		model.addAttribute("member" , memberFormDto);
		return "profile/profile";
	}
	
	

	

}
