package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemCreationController {

	@RequestMapping("/item-creation")
	public String itemCreate() {
		return "item-creation";
	}
}
