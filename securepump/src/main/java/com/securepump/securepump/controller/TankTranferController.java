package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TankTranferController {

	@RequestMapping("/tank-transfer")
	public String tank() {
		return "tank-transfer";
	}
}
