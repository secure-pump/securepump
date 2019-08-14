package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DayOpeningController {
	
	@RequestMapping("/day-opening")
	public String dayOpen()
	{
		return "day-opening";
	}

}
