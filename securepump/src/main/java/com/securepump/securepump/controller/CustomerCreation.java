package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerCreation {

	@RequestMapping("/customer-cretion")
	public String customercreate() {
		return "customer-creation";
	}
	
}
