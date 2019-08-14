package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TankDipEntryController {

	@RequestMapping("/tank-dip-entry")
	public String tankDip() {
		return "tank-dip-entry";
	}
}
