package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.BoyCreationEntity;
import com.securepump.securepump.model.CustomerCreationEntity;
import com.securepump.securepump.service.BoyCreationService;

@Controller
public class BoyCreationController {

	@Autowired
	@Qualifier("boyService")
	BoyCreationService boyService;
	@RequestMapping("/boy-creation")
	public String boyCreate(@ModelAttribute("boycreate") CustomerCreationEntity boyCreate,Model model,@RequestParam(name = "status") String status) {
		List<BoyCreationEntity> listBoy=boyService.getAllCutomer();
		model.addAttribute("listboys",listBoy);
		model.addAttribute("status", status);
		return "boy-creation";
	}
	@RequestMapping(value = "/saveBoy", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("boycreate") BoyCreationEntity boycreate,Model model) {
		//System.out.println("account--"+account);
		String status="error";
		try {
			if(boycreate.getId()==null) {
				status="save";
			}else {
				status="update";
			}
			boyService.createOrUpdateBoy(boycreate);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return "redirect:/boy-creation?status="+status;
	}
	@RequestMapping("/boyEdit/{id}")
	public ModelAndView showEditBoyPage(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
	    ModelAndView mav = new ModelAndView("boy-creation");
	    BoyCreationEntity account = boyService.getBoyById(id);
	    mav.addObject("account", account);
	     
	    return mav;
	}
	@RequestMapping("/boyDelete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		boyService.deleteBoyById(id);
		 return "redirect:/boy-creation?status=delete";
	}
	
}
