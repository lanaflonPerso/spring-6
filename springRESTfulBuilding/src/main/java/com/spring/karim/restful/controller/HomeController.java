package com.spring.karim.restful.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	  public String home(Model model) {
		  model.addAttribute("standardDate", new Date());
	    return "index";
	  }

}
