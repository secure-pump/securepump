package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NozzleCreationController {

	@RequestMapping("/nozzle-creation")
	public String nozzleCreate()
	{
		return "nozzle-creation";
	}
}
