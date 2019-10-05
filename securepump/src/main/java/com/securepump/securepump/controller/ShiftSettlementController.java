package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShiftSettlementController {
	
	@RequestMapping("shift-settlement")
	public String shiftSettlement() {
		return "shift-settlement";
	}
	

}
