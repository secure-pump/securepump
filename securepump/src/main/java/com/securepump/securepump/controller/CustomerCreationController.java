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
import com.securepump.securepump.model.CustomerCreationEntity;
import com.securepump.securepump.service.CustomerCreationService;

@Controller
public class CustomerCreationController {
	@Autowired
	CustomerCreationService customerService;
	@RequestMapping("/customer-cretion") 
	public String customercreate(@ModelAttribute("customer") CustomerCreationEntity customer,Model model ) {
		List<CustomerCreationEntity> listCustomer=customerService.getAllCutomer();
		model.addAttribute("listCustomer",listCustomer);
		return "customer-creation";
	}
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomerDetails(@ModelAttribute("customer") CustomerCreationEntity customer,Model model) {
		System.out.println("Save/Update Customer Details"+customer);
		customerService.createOrUpdateCustomer(customer);
		List<CustomerCreationEntity> listCustomer=customerService.getAllCutomer();
		System.out.println("Customer List Size=="+listCustomer.size());
		model.addAttribute("listCustomers",listCustomer);
		return "customer-creation";
	}
	
	@RequestMapping("/customerEdit/{id}")
	public ModelAndView showEditCustomerDetails(@PathVariable(name="id") Long id) throws RecordNotFoundException{
		ModelAndView mav = new ModelAndView("customer-creation");
		CustomerCreationEntity customer=customerService.getCustomerById(id);
		mav.addObject("customer", customer);
		return mav;
	}
	@RequestMapping("/customerDelete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		customerService.deleteCustomerById(id);
		return "/cutomer-creation";
	}
}
