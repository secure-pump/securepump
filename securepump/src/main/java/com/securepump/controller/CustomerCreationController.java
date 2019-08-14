package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerCreationController {

	@RequestMapping("/customer-cretion")
	public String customercreate() {
		return "customer-creation";
	}
	
}
