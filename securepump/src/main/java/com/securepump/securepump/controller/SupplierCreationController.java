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
import com.securepump.securepump.model.SupplierCreationEntity;
import com.securepump.securepump.service.SupplierCreationService;
@Configurable
@Controller
public class SupplierCreationController {
	@Autowired
	SupplierCreationService suplierService;
	@RequestMapping("/supplier-creation")
	public String supplierCreate(@ModelAttribute("supplier") SupplierCreationEntity supplier,Model model,@RequestParam(name = "status") String status ) {
		List<SupplierCreationEntity> listSuppliers=suplierService.getAllSuppliers();
		model.addAttribute("listSuppliers", listSuppliers);
		model.addAttribute("status", status);
		return "supplier-creation";
	}
	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST)
	public String editSaveSupplier(@ModelAttribute("supplier") SupplierCreationEntity supplier, Model model)
	{
		String status="error";
		try {
			if(supplier.getId()==null) {
				status="save";
			}else {
				status="update";
			}
			suplierService.createOrUpdateSupplier(supplier);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		List<SupplierCreationEntity> listSuppliers=suplierService.getAllSuppliers();
		System.out.println("Suppliersize=="+listSuppliers.size());
		model.addAttribute("listSuppliers", listSuppliers);
		return "redirect:/supplier-creation?status="+status;
	}
	@RequestMapping("/supplierEdit/{id}")
	public ModelAndView showEditSupplierPage(@PathVariable(name="id") Long id) throws RecordNotFoundException {
		ModelAndView mav = new ModelAndView("account-creation");
		SupplierCreationEntity supplier=suplierService.getSupplierById(id);
		mav.addObject("supplier",supplier);
		return mav;
		
	}
	@RequestMapping("/supplierDelete/{id}")
	public String deleteSupplier(@PathVariable(name="id") Long id) throws RecordNotFoundException{
		suplierService.deleteSupplierById(id);
		return "redirect:/supplier-creation?status=delete";
	}
	
}
