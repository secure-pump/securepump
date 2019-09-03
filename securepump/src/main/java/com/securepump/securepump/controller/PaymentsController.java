package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentsController {
	@RequestMapping("/payments")
	public String paymentCreate() {
		return "payments";
	}

}
