package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TankCreationController {

	@RequestMapping("/tank-creation")
	public String tankCreate() {
		return "tank-creation";
	}
}
