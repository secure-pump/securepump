package com.securepump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DayOpeningLubsController {

		@RequestMapping("/day-opening-lubs")
		public String dayopenlub() {
			return "day-opening-lubs";
		}
}
