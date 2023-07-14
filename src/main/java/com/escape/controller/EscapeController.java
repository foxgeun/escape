package com.escape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EscapeController {

		@GetMapping(value = "/")
		public String index() {
			return "/index";
		}
		
		
		
		
		
}
