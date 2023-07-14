package com.escape.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrowseController {
	
	@GetMapping(value = "/browse")
	public String browse() {
		return "browse/browse";
	}
	
}
