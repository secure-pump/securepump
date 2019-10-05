package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.service.ItemCreationService;

@RestController
public class ItemRestController {
	@Autowired
	ItemCreationService itemService;
	@RequestMapping("/item-creation-rest")
	public List<ItemCreationEntity> itemCreate(@ModelAttribute("item") ItemCreationEntity item,Model model,@RequestParam(name = "status") String status) {
		List<ItemCreationEntity> listAccounts = itemService.getAllItems();		
	   /* model.addAttribute("listItems", listAccounts);
	  System.out.println("status--"+status);
	   model.addAttribute("status", status);*/
		return listAccounts;
	}

}
