package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurhaseEntryController {

	@RequestMapping("/purchase-entry")
	public String purchaseCreate()
	{
		return "purchase-entry";
	}
}
