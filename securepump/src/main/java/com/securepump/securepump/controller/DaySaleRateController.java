package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.model.TankCreationEntity;
import com.securepump.securepump.service.ItemCreationService;
import com.securepump.securepump.service.TankCreationService;

@Controller

public class DaySaleRateController {
	@Autowired
	ItemCreationService itemService;		
	@RequestMapping("/day-sale-rate")
	public String daySaleRate(Model model,@RequestParam(name = "status") String status) throws RecordNotFoundException  {
		model.addAttribute("status", status);
		return "day-sale-price";
	}
	 @ModelAttribute("itemNameList")
	 public List<ItemCreationEntity> getAllItemNames() throws RecordNotFoundException {	      
	      List<ItemCreationEntity> allItemNames=itemService.getAllItemNature("Fuel");	      
	      return allItemNames;
	   }
}
