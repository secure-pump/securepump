package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplierCreationController {

	@RequestMapping("/supplier-creation")
	public String supplierCreate() {
		return "supplier-creation";
	}
}
