package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HomeRestController {
	
	@RequestMapping
	public String home() {
		return "welcome home";
	}
}
