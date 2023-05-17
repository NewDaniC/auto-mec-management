package com.utfpr.mecanica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SobreController {
	
	@GetMapping("/sobre/sobre")
	public String sobre() {
		return "sobre/sobre";
	}
}