package com.karim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PagesController {

	@GetMapping("/home")
	public String home() {
		return "pages/home";
	}
}
