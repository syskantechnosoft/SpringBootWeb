package com.uhg.webboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("index")
	public String welcome() {
		return "index";
	}

}
