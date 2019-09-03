package com.securepump.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JournalVoucherController {
	@RequestMapping("/journal-voucher")
	public String journalVoucherCreate() {
		return "journal-voucher";
	}

}
