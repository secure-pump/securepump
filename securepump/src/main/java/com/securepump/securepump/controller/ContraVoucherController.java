package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContraVoucherController {

	@RequestMapping("/contra-voucher")
	public String contraVoucherCreate() {
		return "contra-voucher";
	}
}
