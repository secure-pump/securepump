package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.service.ItemCreationService;

@Controller
public class ItemCreationController {

	@Autowired
	ItemCreationService itemService;
	@RequestMapping("/item-creation")
	public String itemCreate(@ModelAttribute("item") ItemCreationEntity item,Model model,@RequestParam(name = "status") String status) {
		List<ItemCreationEntity> listAccounts = itemService.getAllItems();		
	    model.addAttribute("listItems", listAccounts);
	  System.out.println("status--"+status);
	   model.addAttribute("status", status);
		return "item-creation";
	}
	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("item") ItemCreationEntity item,Model model) {
		//System.out.println("account--"+account);
		String status="error";
		try {
			if(item.getId()!=null) {
				itemService.createorUpdateItem(item);
				status="update";
				return "redirect:/item-creation?status="+status;
			}
			boolean itemstatus=itemService.getItemByName(item.getItemName());
			if(itemstatus==true) {
				System.out.println("Item Already Exist");
				status="exist";
				return "redirect:/item-creation?status="+status;
			}
			else {
				status="save";
				itemService.createorUpdateItem(item);
				return "redirect:/item-creation?status="+status;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return "redirect:/item-creation?status="+status;
	}
	@RequestMapping("/itemEdit/{id}")
	public ModelAndView showEditItemPage(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
	    ModelAndView mav = new ModelAndView("item-creation");
	    ItemCreationEntity item = itemService.getItemById(id);
	    mav.addObject("item", item);
	     
	    return mav;
	}
	@RequestMapping("/itemDelete/{id}")
	public String deleteItem(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		itemService.deleteItemById(id);
		 return "redirect:/item-creation?status=delete";
	}
}
