package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DayClosingController {

	@RequestMapping("/day-closing")
	public String dayClose() {
		return "day-closing";
	}
}
