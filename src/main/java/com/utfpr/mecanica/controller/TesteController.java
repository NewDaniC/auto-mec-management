package com.utfpr.mecanica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {
	
	@GetMapping("/teste/sideBar")
	public String sideBar() {
		return "teste/sideBar";
	}
}
