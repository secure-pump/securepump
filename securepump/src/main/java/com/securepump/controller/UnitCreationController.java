package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnitCreationController {

	@RequestMapping("/unit-creation")
	public String untiCreation() {
		return "unit-creation";
	}
}
