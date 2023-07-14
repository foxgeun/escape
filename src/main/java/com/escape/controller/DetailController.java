package com.escape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailController {
	
	@GetMapping(value = "/details")
	public String details() {
		return "detail/details";
	}
}
