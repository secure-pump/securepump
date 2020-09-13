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
import com.securepump.securepump.model.AccountCreationEntity;
import com.securepump.securepump.model.CustomerCreationEntity;
import com.securepump.securepump.model.UnitCreationEntity;
import com.securepump.securepump.service.UnitCreationService;

@Controller
public class UnitCreationController {
	
	@Autowired
	@Qualifier("unitservice")
	UnitCreationService unitService;
	
	@RequestMapping("/unit-creation")
	public String untiCreation(@ModelAttribute("unit") UnitCreationEntity unit,Model model,@RequestParam(name = "status") String status) {
		List<UnitCreationEntity> listUnits = unitService.getAllUnits();		
	    model.addAttribute("listUnits", listUnits);
	    System.out.println("status--"+status);
	    model.addAttribute("status", status);
		return "unit-creation";
	}
	@RequestMapping(value = "/saveUnitName", method = RequestMethod.POST)
	public String saveUnitNameDetails(@ModelAttribute("unit") UnitCreationEntity unit,Model model) {
		System.out.println("Save/Update Customer Details"+unit);
		String status="error";
		try {
			if(unit.getId()!=null) {
				status="update";
				unitService.createOrUpdateUnit(unit);
				return "redirect:/unit-creation?status="+status;
			}
			boolean unitStatus=unitService.getUnitName(unit.getUnitName());
			if(unitStatus==true) {
				status="exist";
				return "redirect:/unit-creation?status="+status;
			}
			else {
				status="save";
				unitService.createOrUpdateUnit(unit);
				return "redirect:/unit-creation?status="+status;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return "redirect:/unit-creation?status="+status;
		
	}
	@RequestMapping("/unitNameEdit/{id}")
	public ModelAndView showEditCustomerDetails(@PathVariable(name="id") Long id) throws RecordNotFoundException{
		ModelAndView mav = new ModelAndView("unit-creation");
		UnitCreationEntity unit=unitService.getUnitById(id);
		mav.addObject("unit", unit);
		return mav;
	}
	@RequestMapping("/unitNameDelete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") Long id,Model model) throws RecordNotFoundException {
		unitService.deleteUnitById(id);
		return "redirect:/unit-creation?status=delete";
	}
	
}
