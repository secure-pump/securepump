package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoyCreationController {

	@RequestMapping("/boy-creation")
	public String boyCreate() {
		return "boy-creation";
	}
}
