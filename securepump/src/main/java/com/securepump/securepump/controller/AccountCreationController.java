package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.AccountCreationEntity;
import com.securepump.securepump.service.AccountCreationService;

@Controller
public class AccountCreationController {
	
	 @Autowired 
	AccountCreationService accountService;

	@RequestMapping("/account-creation")
	public String AccountCreate(@ModelAttribute("account") AccountCreationEntity account,Model model) {
		List<AccountCreationEntity> listAccounts = accountService.getAllAccounts();		
	    model.addAttribute("listAccounts", listAccounts);
	   // model.addAttribute("account", account);
		return "account-creation";
	}
	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("account") AccountCreationEntity account,Model model) {
		System.out.println("account--"+account);
		accountService.createOrUpdateAccounts(account);
		//List<AccountCreationEntity> listAccounts = accountService.getAllAccounts();
		//System.out.println("listAccounts--"+listAccounts.size());
	   // model.addAttribute("listAccounts", listAccounts);
	    return "redirect:/account-creation?status=de";
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
		//List<AccountCreationEntity> listAccounts = accountService.getAllAccounts();
	    //model.addAttribute("listAccounts", listAccounts);
		 return "redirect:/account-creation";
	}
}
