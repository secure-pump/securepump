package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TankTransactionController {

	@RequestMapping("tank-transaction")
	public String tankTransaction() {
		return "tank-transaction";
	}
	
}
