package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.AccountCreationEntity;
import com.securepump.securepump.service.AccountCreationService;

@Configurable
@Controller
public class AccountCreationController {
	
	 @Autowired 
	AccountCreationService accountService;

	@RequestMapping("/account-creation")
	public String AccountCreate(@ModelAttribute("account") AccountCreationEntity account,Model model,@RequestParam(name = "status") String status) {
		List<AccountCreationEntity> listAccounts = accountService.getAllAccounts();		
	    model.addAttribute("listAccounts", listAccounts);
	  System.out.println("status--"+status);
	   model.addAttribute("status", status);
		return "account-creation";
	}
	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("account") AccountCreationEntity account,Model model) {
		//System.out.println("account--"+account);
		String status="error";
		try {
			if(account.getId()==null) {
				status="save";
			}else {
				status="update";
			}
			accountService.createOrUpdateAccounts(account);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return "redirect:/account-creation?status="+status;
	}
	@RequestMapping("/accountEdit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
	    ModelAndView mav = new ModelAndView("account-creation");
	    AccountCreationEntity account = accountService.getAccountsById(id);
	    mav.addObject("account", account);
	     
	    return mav;
	}
	@RequestMapping("/accountDelete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		accountService.deleteAccountsById(id);
		 return "redirect:/account-creation?status=delete";
	}
}
