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
	//@Qualifier("supplierService")
	SupplierCreationService supplierService;
	
	@RequestMapping("/supplier-creation")
	public String supplierCreate(@ModelAttribute("supplier") SupplierCreationEntity supplier,Model model,@RequestParam(name = "status") String status ) {
		List<SupplierCreationEntity> listSuppliers=supplierService.getAllSuppliers();
		model.addAttribute("listSuppliers", listSuppliers);
		model.addAttribute("status", status);
		return "supplier-creation";
	}
	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST)
	public String editSaveSupplier(@ModelAttribute("supplier") SupplierCreationEntity supplier, Model model)
	{
		String status="error";
		try {
			if(supplier.getId()!=null) {
				status="update";
				supplierService.createOrUpdateSupplier(supplier);
				List<SupplierCreationEntity> listSuppliers=supplierService.getAllSuppliers();
				System.out.println("Suppliersize=="+listSuppliers.size());
				model.addAttribute("listSuppliers", listSuppliers);
				return "redirect:/supplier-creation?status="+status;
			}
			boolean record=supplierService.getSupplierNameOrMobile(supplier.getSupplierName(), supplier.getMobileNo());
			if(record==true) {
				status="exist";
				List<SupplierCreationEntity> listSuppliers=supplierService.getAllSuppliers();
				System.out.println("Suppliersize=="+listSuppliers.size());
				model.addAttribute("listSuppliers", listSuppliers);
				return "redirect:/supplier-creation?status="+status;
			}
			else {
				status="save";
				supplierService.createOrUpdateSupplier(supplier);
				List<SupplierCreationEntity> listSuppliers=supplierService.getAllSuppliers();
				System.out.println("Suppliersize=="+listSuppliers.size());
				model.addAttribute("listSuppliers", listSuppliers);
				return "redirect:/supplier-creation?status="+status;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		List<SupplierCreationEntity> listSuppliers=supplierService.getAllSuppliers();
		System.out.println("Suppliersize=="+listSuppliers.size());
		model.addAttribute("listSuppliers", listSuppliers);
		return "redirect:/supplier-creation?status="+status;
	}
	@RequestMapping("/supplierEdit/{id}")
	public ModelAndView showEditSupplierPage(@PathVariable(name="id") Long id) throws RecordNotFoundException {
		ModelAndView mav = new ModelAndView("account-creation");
		SupplierCreationEntity supplier=supplierService.getSupplierById(id);
		mav.addObject("supplier",supplier);
		return mav;
		
	}
	@RequestMapping("/supplierDelete/{id}")
	public String deleteSupplier(@PathVariable(name="id") Long id) throws RecordNotFoundException{
		supplierService.deleteSupplierById(id);
		return "redirect:/supplier-creation?status=delete";
	}
	
}
